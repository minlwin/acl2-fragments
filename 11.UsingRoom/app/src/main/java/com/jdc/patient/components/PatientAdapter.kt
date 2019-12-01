package com.jdc.patient.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jdc.patient.R
import com.jdc.patient.model.entity.Patient
import kotlinx.android.synthetic.main.item_patient.view.*

class PatientAdapter(private val list: List<Patient>): RecyclerView.Adapter<PatientAdapter.PatientVH>() {

    class PatientVH(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_patient, parent, false).let {
                PatientVH(it)
            }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PatientVH, position: Int) {
        holder.itemView.also {
            it.name.text = list[position].name
            it.phone.text = list[position].phone
            it.gender.text = list[position].gender?.name?.substring(0, 1)?.toUpperCase() ?: "M"
        }
    }
}