package com.jdc.passing


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_pass_data.*

/**
 * A simple [Fragment] subclass.
 */
class PassDataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pass_data, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        arguments?.also {
            val message = it.getString("message", "Hello Fragment")
            textView.text = message
        }
    }

}
