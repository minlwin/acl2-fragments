package com.jdc.data


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_edit.*

class EditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        button.setOnClickListener {
            val name = input.text.toString()

            if(name.isNotEmpty()) {
                val action = EditFragmentDirections.actionEditToDetails(name)
                it.findNavController().navigate(action)
            }
        }
    }
}
