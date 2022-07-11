package com.example.mycv.DBmodels

data class Course(
    val id: Long,
    val name: String,
    val trainingCenter: String,
    val duration: Int,
    val description: String,
    val geoPosition: GeoPosition,
    val centerImageURL: String,
    val centerWebURL: String

)
