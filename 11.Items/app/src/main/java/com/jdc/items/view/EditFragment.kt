package com.jdc.items.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.navigation.findNavController
import com.jdc.items.MainActivity

import com.jdc.items.R
import com.jdc.items.model.converter.Category
import com.jdc.items.model.entity.Item
import kotlinx.android.synthetic.main.fragment_edit.*

/**
 * A simple [Fragment] subclass.
 */
class EditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val categories = ArrayAdapter(context!!, android.R.layout.simple_spinner_dropdown_item, Category.values())
        category.adapter = categories

        var id:Int? = null

        arguments?.getSerializable("item")?.also {

            val item = it as Item

            title.text = "Edit Item"
            name.setText(item.name)
            category.setSelection(item.category?.ordinal ?: 0)
            price.setText(item.price.toString())
            description.setText(item.description)

            (context as MainActivity)?.also {
                it.setTitle("Edit Item")
            }

            id = item.id
        }

        button.setOnClickListener {

            val item = Item(
                id = id,
                name = name.text.toString(),
                category = category.selectedItem as Category,
                price = price.text.toString().toInt(),
                description = description.text.toString()
            )

            val dao = (context as MainActivity)?.database.itemDao()

            if(item.id == null) {
                dao.create(item)
            } else {
                dao.update(item)
            }

            it.findNavController().navigate(R.id.list)
        }
    }

}
