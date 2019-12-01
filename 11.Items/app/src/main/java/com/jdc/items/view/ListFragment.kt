package com.jdc.items.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdc.items.MainActivity

import com.jdc.items.R
import com.jdc.items.adapter.ItemAdapter
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (context as MainActivity).database.itemDao().getAll().also {
            items.layoutManager = LinearLayoutManager(context)
            items.adapter = ItemAdapter().also { a ->
                a.submitList(it)
            }
        }
    }

}
