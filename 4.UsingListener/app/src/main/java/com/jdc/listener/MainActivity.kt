package com.jdc.listener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jdc.listener.model.Contact
import com.jdc.listener.model.ContactModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, ListFragment())
            .commit()
    }

    override fun onAttachFragment(fragment: Fragment) {

        if(fragment is ListFragment) {
            fragment.addAction = {
                // load edit fragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, EditFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }

        if(fragment is EditFragment) {
            fragment.saveAction = ::save
        }
    }

    private fun save(c:Contact) {
        ContactModel.add(c)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ListFragment())
            .addToBackStack(null)
            .commit()
    }
}
