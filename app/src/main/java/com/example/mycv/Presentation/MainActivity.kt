package com.example.mycv.Presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.mycv.Presentation.Employment.Fragments.CreateEmploymentFragment
import com.example.mycv.Presentation.Employment.Fragments.EmploymentListFragment
import com.example.mycv.Presentation.degree.fragment.DegreeListFragment
import com.example.mycv.Presentation.interfaces.OnClickListener
import com.example.mycv.R
import com.example.mycv.Room.db_models.EmploymentEntity
import com.example.mycv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mActiveFragment: Fragment
    private lateinit var mFragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavBar()
    }


    private fun setupBottomNavBar(args: Bundle? = null) {
//        if( args !=null) fragment.arguments = args
        mFragmentManager = supportFragmentManager

        val employmentListFragment = EmploymentListFragment()
        val createEmploymentFragment = CreateEmploymentFragment()
        val degreeListFragment = DegreeListFragment()
        mActiveFragment = employmentListFragment

        mFragmentManager.beginTransaction()
            .add(R.id.hostFragment, employmentListFragment, EmploymentListFragment::class.java.name)
            .addToBackStack(null)
            .hide(employmentListFragment)
            .commit()

        mFragmentManager.beginTransaction()
            .add(R.id.hostFragment,createEmploymentFragment,CreateEmploymentFragment::class.java.name)
            .addToBackStack(null)
            .hide(createEmploymentFragment)
            .commit()
        mFragmentManager.beginTransaction()
            .add(R.id.hostFragment, degreeListFragment, DegreeListFragment::class.java.name)
            .addToBackStack(null)
            .hide(degreeListFragment)
            .commit()

//        mFragmentManager.beginTransaction()
//            .add(R.id.hostFragment, profile, profileUser::class.java.name)
//            .addToBackStack(null)
//            .hide(profile)
//            .commit()

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_employment -> {
                    mFragmentManager.beginTransaction()
                        .hide(mActiveFragment)
                        .show(employmentListFragment)
                        .commit()

                    mActiveFragment = employmentListFragment
                    true
                }
                R.id.action_degree -> {
                    mFragmentManager.beginTransaction()
                        .hide(mActiveFragment)
                        .show(degreeListFragment)
                        .commit()
                    mActiveFragment = degreeListFragment
                    true
                }
                R.id.action_course -> {}
                R.id.action_profile -> {}

            }
            true
        }


    }


    /**
     * OnClickListener interface
     */
    override fun onClick(employmentEntity: EmploymentEntity) {
//        binding.rvEmployment
    }


}