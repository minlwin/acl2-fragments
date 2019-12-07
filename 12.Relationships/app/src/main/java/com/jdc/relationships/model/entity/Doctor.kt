package com.jdc.relationships.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Doctor(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var name:String? = null,
    var phone:String? = null
):Serializable