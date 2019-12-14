package com.jdc.relationships.model.vo

import androidx.room.Embedded
import androidx.room.Relation
import com.jdc.relationships.model.entity.Patient
import com.jdc.relationships.model.entity.Registration

data class PatientRegistrations(
    @Embedded
    val patient: Patient,
    @Relation(
        parentColumn = "id",
        entityColumn = "patientId"
    )
    val registrations: List<Registration>
)