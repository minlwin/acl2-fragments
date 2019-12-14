package com.jdc.relationships.model.converter

import androidx.room.TypeConverter
import com.jdc.relationships.model.entity.Section

class SectionConverter {

    @TypeConverter
    fun sectionToInt(section: Section?):Int? = section?.ordinal

    @TypeConverter
    fun intToSection(int: Int?):Section? = int?.let {
        Section.values()[it]
    }
}