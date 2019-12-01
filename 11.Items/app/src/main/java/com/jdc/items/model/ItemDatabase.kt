package com.jdc.items.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jdc.items.model.converter.CategoryConverter
import com.jdc.items.model.dao.ItemDao
import com.jdc.items.model.entity.Item

@Database(
    entities = [Item::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [CategoryConverter::class])
abstract class ItemDatabase: RoomDatabase() {

    abstract fun itemDao():ItemDao
}