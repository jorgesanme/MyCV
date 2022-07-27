package com.example.mycv.Presentation.Employment.Fragments

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.example.mycv.CVApp
import com.example.mycv.Presentation.MainActivity
import com.example.mycv.R
import com.example.mycv.Room.db_models.EmploymentEntity
import com.example.mycv.databinding.FragmentCreateEmploymentBinding
import org.jetbrains.anko.doAsync


class CreateEmploymentFragment : Fragment() {

    private lateinit var mBinding: FragmentCreateEmploymentBinding
    private var mActivity: MainActivity? = null
    private var mIsEditMode: Boolean = false
    private var mEmploymentEntity: EmploymentEntity? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCreateEmploymentBinding.inflate(inflater, container,false).also {
        mBinding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity = activity as? MainActivity
        mActivity?.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHasOptionsMenu(true)
            title = getString(R.string.add_employment_title)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_save, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                hideKeyboard()
                mActivity?.onBackPressed()
                true
            }
            R.id.action_save ->{
                with(mEmploymentEntity){
                    this?.workPosition = mBinding.etWorkPosition.text.toString().trim()
                    this?.companyName = mBinding.etCompanyName.text.toString().trim()
                    this?.companyAddress = mBinding.etCompanyAddress.text.toString().trim()
                    this?.timeOnJob = mBinding.etTimeOnJob.text.toString().trim().toInt()
                    this?.jobDescription = mBinding.etJobDescription.text.toString().trim()

                }
                doAsync {
                    mEmploymentEntity?.let {
                        it.id = CVApp.database.employmentDao().addEmployment(it)
                    }

                }
                hideKeyboard()

                true
            }

        else ->super.onOptionsItemSelected(item)
        }

    }


    private fun hideKeyboard() {
        val imm = mActivity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().windowToken, 0)
    }



}