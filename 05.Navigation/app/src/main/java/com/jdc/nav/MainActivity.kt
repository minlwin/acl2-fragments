package com.jdc.nav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        home.setOnClickListener {
            fragment.findNavController().navigate(R.id.action_global_home)
        }

        category.setOnClickListener {
            fragment.findNavController().navigate(R.id.action_global_category)
        }

        setting.setOnClickListener {
            fragment.findNavController().navigate(R.id.action_global_setting)
        }
    }
}
