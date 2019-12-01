package com.jdc.patient

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.fragment.findNavController

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val navController = container.findNavController()

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.patient_list) {
                fab.show()
            } else {
                fab.hide()
            }
        }

        fab.setOnClickListener {
            navController.navigate(R.id.action_patient_list_to_patient_edit)
    }

    }

}
