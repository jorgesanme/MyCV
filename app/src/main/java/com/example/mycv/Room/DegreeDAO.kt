package com.example.mycv.Room

import androidx.room.*
import com.example.mycv.Room.db_models.DegreeEntity

@Dao
interface DegreeDAO {
    @Query("SELECT * FROM DegreeEntity")
    fun getAllEmployment(): MutableList<DegreeEntity>

    @Insert
    fun addEmployment(degreeEntity: DegreeEntity)

    @Update
    fun updateEmployment(degreeEntity: DegreeEntity)

    @Delete
    fun deleteEmployment(degreeEntity: DegreeEntity)
}