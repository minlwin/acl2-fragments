package com.jdc.listener.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jdc.listener.R
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ContactViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
    )

    override fun getItemCount(): Int = ContactModel.list.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = ContactModel.list[position]
        holder.itemView.header.text = item.header
        holder.itemView.name.text = item.name
        holder.itemView.phone.text = item.phone
        holder.itemView.email.text = item.email
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}