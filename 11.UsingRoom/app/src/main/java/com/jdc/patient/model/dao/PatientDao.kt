package com.jdc.patient.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jdc.patient.model.entity.Patient

@Dao
interface PatientDao {

    @Insert
    fun insert(vararg patients:Patient)

    @Query("select * from PATIENT")
    fun findAll():List<Patient>
}