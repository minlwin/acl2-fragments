package com.jdc.items.adapter

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.jdc.items.model.entity.Item

class CustomCallBack(direction: Int, private val action:(data:Item)->Unit): ItemTouchHelper.SimpleCallback(0, direction) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = true

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        (viewHolder as ItemAdapter.ItemVH).item?.also(action)
    }
}