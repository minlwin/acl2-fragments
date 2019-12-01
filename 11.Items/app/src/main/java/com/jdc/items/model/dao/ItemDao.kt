package com.jdc.items.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jdc.items.model.entity.Item

@Dao
interface ItemDao {

    @Query("select * from Item")
    fun getAll():List<Item>

    @Insert
    fun create(item: Item)
}