package com.jdc.patient.model

import androidx.room.TypeConverter
import com.jdc.patient.model.entity.Gender

class GenderConverter {

    @TypeConverter
    fun genderToString(gender: Gender?):String? {
        return gender?.let { it.name }
    }

    @TypeConverter
    fun stringToGender(string: String?):Gender? {
        return string?.let {
            Gender.valueOf(it)
        }
    }
}