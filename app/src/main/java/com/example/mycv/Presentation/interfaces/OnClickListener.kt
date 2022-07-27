package com.example.mycv.Presentation.interfaces

import com.example.mycv.Room.db_models.EmploymentEntity

interface OnClickListener {
    fun onClick(employmentEntity: EmploymentEntity)
}