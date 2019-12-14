package com.jdc.relationships.ui


import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdc.relationships.MainActivity

import com.jdc.relationships.R
import com.jdc.relationships.component.DoctorAdaptor
import com.jdc.relationships.model.entity.Doctor
import kotlinx.android.synthetic.main.fragment_doctor.*

/**
 * A simple [Fragment] subclass.
 */
class DoctorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val mainActivity:MainActivity = context as MainActivity
        val doctorDao = mainActivity.database.doctorDao()

        val adaptor = DoctorAdaptor()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adaptor


        val list = object : AsyncTask<Void, Void, List<Doctor>>() {

            override fun doInBackground(vararg p0: Void?): List<Doctor> {
                return doctorDao.findAllDoctors()
            }

        }.execute().get()

        adaptor.submitList(list)
    }


}
