package com.jdc.patient.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jdc.patient.model.dao.PatientDao
import com.jdc.patient.model.entity.Patient

@Database(
    entities = [Patient::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(GenderConverter::class)
abstract class PatientDatabase: RoomDatabase() {

    abstract fun patientDao():PatientDao

    companion object {

        private lateinit var db:PatientDatabase

        fun getDatabase(context:Context):PatientDatabase {

            if(!::db.isInitialized) {
                db = Room.databaseBuilder(context,
                    PatientDatabase::class.java, "com.jdc.patient_db")
                    .allowMainThreadQueries()
                    .build()
            }

            return db
        }
    }
}