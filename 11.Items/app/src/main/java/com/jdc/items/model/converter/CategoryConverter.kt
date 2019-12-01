package com.jdc.items.model.converter

import androidx.room.TypeConverter

class CategoryConverter {

    @TypeConverter
    fun categoryToString(c:Category?):String? {
        return c?.name
    }

    @TypeConverter
    fun stringToCategory(s:String?):Category? {
        return s?.let { Category.valueOf(it) }
    }
}