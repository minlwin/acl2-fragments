package com.jdc.items.model.dao

import androidx.room.*
import com.jdc.items.model.entity.Item

@Dao
interface ItemDao {

    @Query("select * from Item")
    fun getAll():List<Item>

    @Insert
    fun create(item: Item)

    @Delete
    fun delete(item: Item)

    @Update
    fun update(item: Item)
}