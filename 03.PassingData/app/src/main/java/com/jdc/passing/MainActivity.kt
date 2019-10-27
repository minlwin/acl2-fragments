package com.jdc.passing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PassDataFragment().also {

            it.arguments = Bundle().also {
                bundle -> bundle.putString("message", "Passing Data ...")
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.container, it)
                .commit()
        }

    }
}
