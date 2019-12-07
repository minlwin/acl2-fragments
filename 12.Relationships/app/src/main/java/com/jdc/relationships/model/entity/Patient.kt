package com.jdc.relationships.model.entity

data class Patient(
    var id:Int? = null,
    var name:String? = null,
    var gender:Gender? = null,
    var phone:String? = null
)

enum class Gender {
    Male, Female
}