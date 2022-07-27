package com.example.mycv

import android.app.Application
import androidx.room.Room
import com.example.mycv.Room.CVDatabase

class CVApp : Application() {
    companion object {
        lateinit var database: CVDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            CVDatabase::class.java,
            "CVDatabase")
            .build()
    }
}