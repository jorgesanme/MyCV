package com.example.mycv.DBmodels

data class Employment(
    val id: Long,
    val workPosition: String,
    val companyName: String,
    val companyAddress: String,
    val timeOnJob: Int,
    val jobDescription: String,
    val geoPosition: GeoPosition,
    val companyImageURL: String,
    val companyWebURL: String
)
