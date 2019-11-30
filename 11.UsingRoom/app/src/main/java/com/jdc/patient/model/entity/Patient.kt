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
    var id:Int?,
    var name:String?,
    var phone:String?,
    var address:String?,
    var gender: Gender?
)

enum class Gender {
    Male, Female
}