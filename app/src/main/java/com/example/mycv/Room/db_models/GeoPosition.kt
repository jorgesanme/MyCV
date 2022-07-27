package com.example.mycv.Room.db_models

import androidx.room.Entity

@Entity(tableName = "GeoPosition")
data class GeoPosition(
    val lat: Long,
    val log: Long
)
