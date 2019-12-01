package com.jdc.items.adapter

import androidx.recyclerview.widget.DiffUtil
import com.jdc.items.model.entity.Item

object ItemChangeCallback: DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}