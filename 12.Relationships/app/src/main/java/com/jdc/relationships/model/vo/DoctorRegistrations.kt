package com.jdc.relationships.model.vo

import androidx.room.Embedded
import androidx.room.Relation
import com.jdc.relationships.model.entity.Doctor
import com.jdc.relationships.model.entity.Registration

data class DoctorRegistrations(
    @Embedded
    val doctor: Doctor,
    @Relation(
        parentColumn = "id",
        entityColumn = "doctorId"
    )
    val registrations:List<Registration>
)