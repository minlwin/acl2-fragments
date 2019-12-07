package com.jdc.patient

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var configuration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navController = container.findNavController()

        configuration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, configuration)

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


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}
