package com.jdc.relationships.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jdc.relationships.model.entity.Registration
import com.jdc.relationships.model.entity.Section
import com.jdc.relationships.model.vo.RegistrationVO
import java.util.*

@Dao
interface RegistrationDao {

    @Insert
    fun create(registration: Registration)

    @Update
    fun update(registration: Registration)

    @Query("""
        select 
            r.id, d.name, p.name, r.registDate, 
            r.section, r.token
        from 
            Registration r 
        join 
            Doctor d on r.doctorId = d.id 
        join 
            Patient p on r.patientId = p.id 
        where 
            r.registDate = :date and r.section = :section and r.doctorId = :doctorId
    """)
    fun findByDateAndSection(doctorId:Int, date: Date, section: Section):RegistrationVO
}