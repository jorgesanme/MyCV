package com.example.mycv.Room.db_models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EmploymentEntity")
data class EmploymentEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var workPosition: String,
    var companyName: String,
    var companyAddress: String,
    var timeOnJob: Int,
    var jobDescription: String,
//    val geoPosition: GeoPosition,
    var companyImageURL: String? = "",
    var companyWebURL: String? = ""
)
