package com.example.mycv.Presentation.degree.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycv.R
import com.example.mycv.databinding.FragmentDegreeListBinding

class DegreeListFragment : Fragment() {
    private lateinit var mBinding: FragmentDegreeListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDegreeListBinding.inflate(inflater,container, false).also {
        mBinding = it
    }.root



}