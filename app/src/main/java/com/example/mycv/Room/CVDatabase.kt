package com.example.mycv.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mycv.Room.db_models.CourseEntity
import com.example.mycv.Room.db_models.DegreeEntity
import com.example.mycv.Room.db_models.EmploymentEntity

@Database(
    entities = arrayOf(
        EmploymentEntity::class,
        CourseEntity::class,
        DegreeEntity::class
    ), version = 1
)
abstract class CVDatabase : RoomDatabase() {
    abstract fun employmentDao(): EmploymentDAO
    abstract fun courseDao(): CourseDAO
    abstract fun degreeDao(): DegreeDAO
}
