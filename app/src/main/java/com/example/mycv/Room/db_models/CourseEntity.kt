package com.example.mycv.Room.db_models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CourseEntity")
data class CourseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val trainingCenter: String,
    val duration: Int,
    val description: String,
//    val geoPosition: GeoPosition,
    val centerImageURL: String,
    val centerWebURL: String

)
