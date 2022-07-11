package com.example.mycv.DBmodels

data class Degree(
    val id: Long,
    val faculty: String,
    val name: String,
    val branch: String,
    val note: Float,
    val description: String,
    val geoPosition: GeoPosition,
    val facultyImageUrl: String,
    val facultyWebUrl: String
){

}
