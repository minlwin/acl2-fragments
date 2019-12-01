package com.jdc.patient.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.jdc.patient.PatientApplication

import com.jdc.patient.R
import com.jdc.patient.model.entity.Gender
import com.jdc.patient.model.entity.Patient
import kotlinx.android.synthetic.main.fragment_patient_edit.*

/**
 * A simple [Fragment] subclass.
 */
class PatientEdit : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_patient_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        button.setOnClickListener {

            val patient = Patient(
                name = name.text.toString(),
                phone = phone.text.toString(),
                address = address.text.toString()
            )

            patient.gender = if(gender.isChecked) Gender.Female else Gender.Male

            val application = context?.applicationContext as PatientApplication
            application.db.patientDao().insert(patient)

            it.findNavController().popBackStack()
        }
    }

}
