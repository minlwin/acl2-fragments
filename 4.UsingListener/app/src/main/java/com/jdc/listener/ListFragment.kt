package com.jdc.listener


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdc.listener.model.ContactAdapter
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    lateinit var addAction:()->Unit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        list.layoutManager = LinearLayoutManager(this.context)
        list.adapter = ContactAdapter()

        button.setOnClickListener {
            if(::addAction.isInitialized) {
                addAction()
            }
        }
    }

}
