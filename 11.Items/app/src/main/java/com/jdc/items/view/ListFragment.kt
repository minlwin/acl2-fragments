package com.jdc.items.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdc.items.MainActivity

import com.jdc.items.R
import com.jdc.items.adapter.CustomCallBack
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

        val dao = (context as MainActivity).database.itemDao()
        val adapter = ItemAdapter()
        items.layoutManager = LinearLayoutManager(context)
        items.adapter = adapter
        adapter.submitList(dao.getAll())

        ItemTouchHelper(CustomCallBack(ItemTouchHelper.RIGHT) {
            dao.delete(it)
            adapter.submitList(dao.getAll())
        }).attachToRecyclerView(items)

        ItemTouchHelper(CustomCallBack(ItemTouchHelper.LEFT) {
            val bundle = Bundle()
            bundle.putSerializable("item", it)
            view.findNavController().navigate(R.id.action_list_to_edit, bundle)
        }).attachToRecyclerView(items)
    }

}
