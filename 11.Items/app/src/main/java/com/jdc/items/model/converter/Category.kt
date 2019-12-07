package com.jdc.items.model.converter

enum class Category {

    Foods, Drinks, Fashion, Accessories;

    val header:String
        get() = name.substring(0, 1)
}