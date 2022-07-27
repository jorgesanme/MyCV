package com.example.mycv.Room.db_models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DegreeEntity")
data class DegreeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val faculty: String,
    val name: String,
    val branch: String,
    val note: Float,
    val description: String,
//    val geoPosition: GeoPosition,
    val facultyImageUrl: String,
    val facultyWebUrl: String
){

}
