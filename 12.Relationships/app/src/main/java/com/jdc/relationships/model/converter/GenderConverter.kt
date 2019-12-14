package com.jdc.relationships.model.converter

import androidx.room.TypeConverter
import com.jdc.relationships.model.entity.Gender

class GenderConverter {

    @TypeConverter
    fun genderToInt(gender: Gender?):Int? = gender?.ordinal

    @TypeConverter
    fun intToGender(int: Int?):Gender? = int?.let {
        Gender.values()[it]
    }
}