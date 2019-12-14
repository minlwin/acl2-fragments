package com.jdc.relationships.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jdc.relationships.model.entity.Doctor
import com.jdc.relationships.model.vo.DoctorRegistrations

@Dao
interface DoctorDao {

    @Insert
    fun create(doctor: Doctor)

    @Update
    fun update(doctor: Doctor)

    @Query("select * from Doctor")
    fun findAllDoctors():List<Doctor>

    @Query("select * from Doctor where id = :id")
    fun findById(id:Int):DoctorRegistrations
}