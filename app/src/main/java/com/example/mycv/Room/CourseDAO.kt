package com.example.mycv.Room

import androidx.room.*
import com.example.mycv.Room.db_models.CourseEntity


@Dao
interface CourseDAO {
    @Query("SELECT * FROM CourseEntity")
    fun getAllEmployment(): MutableList<CourseEntity>

    @Insert
    fun addEmployment(courseEntity: CourseEntity)

    @Update
    fun updateEmployment(courseEntity: CourseEntity)

    @Delete
    fun deleteEmployment(courseEntity: CourseEntity)
}