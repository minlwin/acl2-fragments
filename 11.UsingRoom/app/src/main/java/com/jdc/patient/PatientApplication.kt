package com.jdc.patient

import android.app.Application
import com.jdc.patient.model.PatientDatabase

class PatientApplication : Application() {

    lateinit var db:PatientDatabase

    override fun onCreate() {
        super.onCreate()
        db = PatientDatabase.getDatabase(this)
    }
}