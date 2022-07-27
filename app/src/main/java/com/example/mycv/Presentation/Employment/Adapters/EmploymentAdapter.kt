package com.example.mycv.Presentation.Employment.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycv.R
import com.example.mycv.Room.db_models.EmploymentEntity
import com.example.mycv.databinding.ItemEmploymentBinding

class EmploymentAdapter(
    private var employments: MutableList<EmploymentEntity>,
    private var listener: Context
) : RecyclerView.Adapter<EmploymentAdapter.EmploymentVH>() {

    private lateinit var mContext: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmploymentVH {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_employment, parent, false)
        return EmploymentVH(view)
    }

    override fun onBindViewHolder(holder: EmploymentVH, position: Int) {
        val employment = employments[position]
        with(holder) {
            setListener(employment)
            binding.workPosition.text = employment.workPosition
            binding.companyName.text = employment.companyName
            binding.timeOnJob.text = employment.timeOnJob.toString()
            binding.jobDescription.text = employment.jobDescription
        }
    }

    override fun getItemCount() = employments.size

    fun setEmployments(employments: MutableList<EmploymentEntity>) {
        this.employments = employments
        notifyDataSetChanged()
    }

    inner class EmploymentVH(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemEmploymentBinding.bind(view)
        fun setListener(employment: EmploymentEntity) {
            binding.root.setOnClickListener {
//                listener.onClick(employment)
            }
        }
    }
}