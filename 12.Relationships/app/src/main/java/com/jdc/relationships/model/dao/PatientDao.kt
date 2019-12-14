package com.jdc.relationships.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jdc.relationships.model.entity.Patient
import com.jdc.relationships.model.vo.PatientRegistrations

@Dao
interface PatientDao {

    @Insert
    fun create(patient: Patient)

    @Update
    fun update(patient: Patient)

    @Query("select * from Patient")
    fun findAll():List<Patient>

    @Query("select * from Patient where id = :id")
    fun findById(id:Int):PatientRegistrations
}