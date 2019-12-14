package com.jdc.relationships.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Patient(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var name:String? = null,
    var gender:Gender? = null,
    var phone:String? = null
)

enum class Gender {
    Male, Female
}