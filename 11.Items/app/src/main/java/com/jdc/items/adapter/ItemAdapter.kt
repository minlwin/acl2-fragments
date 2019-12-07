package com.jdc.items.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.items.R
import com.jdc.items.model.entity.Item
import kotlinx.android.synthetic.main.item_item.view.*

class ItemAdapter :
    ListAdapter<Item, ItemAdapter.ItemVH>(ItemChangeCallback) {

    class ItemVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item:Item? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemVH(
        LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false)
    )

    override fun onBindViewHolder(holder: ItemVH, position: Int) {

        val item = getItem(position)

        holder.itemView.also {
            it.category.text = item.category?.header ?: "C"
            it.name.text = item.name
            it.price.text = "${item.price} MMK"
        }

        holder.item = item
    }
}