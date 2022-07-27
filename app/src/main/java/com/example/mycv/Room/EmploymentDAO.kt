package com.example.mycv.Room

import androidx.room.*
import com.example.mycv.Room.db_models.EmploymentEntity

@Dao
interface EmploymentDAO {

    @Query("SELECT * FROM EmploymentEntity")
    fun getAllEmployment(): MutableList<EmploymentEntity>

    @Query("SELECT * FROM EmploymentEntity WHERE ID = :id")
    fun getEmploymentById(id: Long): EmploymentEntity

    @Insert
    fun addEmployment(employmentEntity: EmploymentEntity): Long

    @Update
    fun updateEmployment(employmentEntity: EmploymentEntity)

    @Delete
    fun deleteEmployment(employmentEntity: EmploymentEntity)

}