package com.jdc.relationships.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jdc.relationships.model.converter.DateConverter
import com.jdc.relationships.model.converter.GenderConverter
import com.jdc.relationships.model.converter.SectionConverter
import com.jdc.relationships.model.dao.DoctorDao
import com.jdc.relationships.model.dao.PatientDao
import com.jdc.relationships.model.dao.RegistrationDao
import com.jdc.relationships.model.entity.Doctor
import com.jdc.relationships.model.entity.Patient
import com.jdc.relationships.model.entity.Registration

@Database(
    entities = [
        Patient::class,
        Doctor::class,
        Registration::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [
    DateConverter::class,
    GenderConverter::class,
    SectionConverter::class
])
abstract class ClinicDatabase:RoomDatabase() {
    abstract fun doctorDao():DoctorDao
    abstract fun patientDao():PatientDao
    abstract fun registrationDao():RegistrationDao
}