package com.jdc.items

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.jdc.items.model.ItemDatabase

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    lateinit var database:ItemDatabase
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        database = Room.databaseBuilder(this, ItemDatabase::class.java, "com.jdc.item_db")
            .allowMainThreadQueries().build()

        navController = fragment.findNavController()
        val configuration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, configuration)

        navController.addOnDestinationChangedListener { _, d, _ ->

            when(d.id) {
                R.id.list -> fab.show()
                else -> fab.hide()
            }
        }

        fab.setOnClickListener {
            navController.navigate(R.id.action_list_to_edit)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun setTitle(title:String) {
        toolbar.title = title
    }

}
