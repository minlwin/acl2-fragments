package com.jdc.relationships.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.relationships.R
import com.jdc.relationships.model.entity.Doctor
import kotlinx.android.synthetic.main.item_doctor.view.*

class DoctorAdaptor() :
    ListAdapter<Doctor, DoctorAdaptor.DoctorVH>(object : DiffUtil.ItemCallback<Doctor>() {

        override fun areItemsTheSame(oldItem: Doctor, newItem: Doctor) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Doctor, newItem: Doctor) = oldItem == newItem

    }) {

    class DoctorVH(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DoctorVH(LayoutInflater.from(parent.context).inflate(
        R.layout.item_doctor, parent, false
    ))

    override fun onBindViewHolder(holder: DoctorVH, position: Int) {
        val doctor = getItem(position)
        holder.itemView.name.text = doctor.name
        holder.itemView.phone.text = doctor.phone
    }
}