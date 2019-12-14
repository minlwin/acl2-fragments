package com.jdc.relationships.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Registration(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var registDate:Date? = null,
    var doctorId:Int? = null,
    var patientId:Int? = null,
    var section: Section? = null,
    var token:Int? = null
)

enum class Section {
    Morning, Evening
}