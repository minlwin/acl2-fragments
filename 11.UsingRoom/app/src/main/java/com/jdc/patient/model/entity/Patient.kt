package com.jdc.patient.model.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "PATIENT",
    indices = [
        Index(value = ["name", "phone"])
    ]
)
data class Patient(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var name:String? = null,
    var phone:String? = null,
    var address:String? = null,
    var gender: Gender? = null
)

enum class Gender {
    Male, Female
}