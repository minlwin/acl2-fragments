package com.jdc.patient.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdc.patient.PatientApplication

import com.jdc.patient.R
import com.jdc.patient.components.PatientAdapter
import kotlinx.android.synthetic.main.fragment_patient_list.*

/**
 * A simple [Fragment] subclass.
 */
class PatientList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_patient_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val application = context?.applicationContext as PatientApplication
        val list = application.db.patientDao().findAll()

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = PatientAdapter(list)
    }
}
