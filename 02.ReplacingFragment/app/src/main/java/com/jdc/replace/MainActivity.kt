package com.jdc.replace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, HomeFragment())
            .commit()

        home.setOnClickListener {
            replace(HomeFragment())
        }

        category.setOnClickListener {
            replace(CategoryFragment())
        }

        setting.setOnClickListener {
            replace(SettingFragment())
        }
    }

    private fun replace(fragment:Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
