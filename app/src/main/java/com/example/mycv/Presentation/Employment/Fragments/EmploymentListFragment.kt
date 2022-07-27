package com.example.mycv.Presentation.Employment.Fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycv.CVApp
import com.example.mycv.Presentation.Employment.Adapters.EmploymentAdapter
import com.example.mycv.Presentation.MainActivity
import com.example.mycv.R
import com.example.mycv.Room.db_models.EmploymentEntity
import com.example.mycv.databinding.FragmentEmploymentListBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EmploymentListFragment : Fragment() {

    private lateinit var mBinding: FragmentEmploymentListBinding
    private lateinit var mAdapter: EmploymentAdapter
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private lateinit var mFragmentManager: FragmentManager
    var mEmployments = mutableListOf<EmploymentEntity>()
    private var mActivity: Activity? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentEmploymentListBinding.inflate(inflater, container, false).also {
        mBinding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity).also { mActivity = it }
        setupView()
        setupToolBar()
        setupList()
        setupRecycleView()

    }

    private fun setupToolBar() {
        val activity = activity as? MainActivity
        activity?.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.list_employment_title)
        }
    }



    private fun setupView() {
        if (mEmployments.isNullOrEmpty()) {
            mBinding.rvEmployment.visibility = View.GONE
            mBinding.addCardView.visibility = View.VISIBLE
        }
        mBinding.addCardView.setOnClickListener { openAddEmployment()}
        mBinding.imgAdd.setOnClickListener { openAddEmployment()

        }
    }

    private fun openAddEmployment() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.add(R.id.hostFragment,CreateEmploymentFragment(), CreateEmploymentFragment::class.java.name)
            ?.commit()
         mBinding.addCardView.visibility = View.GONE
    }

    private fun setupRecycleView() {
        mLinearLayoutManager = LinearLayoutManager(requireContext())

        mAdapter = EmploymentAdapter(mEmployments, requireContext())
        mBinding.rvEmployment.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayoutManager
            adapter = mAdapter
        }
    }

    private fun setupList() {
        doAsync {
            val employments = CVApp.database.employmentDao().getAllEmployment()
            uiThread {
                mAdapter.setEmployments(employments)
            }
        }
    }

}