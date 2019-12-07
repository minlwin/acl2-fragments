package com.jdc.items.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jdc.items.model.converter.Category
import java.io.Serializable

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var name:String?,
    var category: Category? = null,
    var price:Int = 0,
    var description:String? = null
):Serializable