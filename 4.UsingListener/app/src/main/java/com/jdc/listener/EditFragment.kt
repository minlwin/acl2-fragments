package com.jdc.listener


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.jdc.listener.model.Contact
import kotlinx.android.synthetic.main.fragment_edit.*

/**
 * A simple [Fragment] subclass.
 */
class EditFragment : Fragment() {

    lateinit var saveAction:(c:Contact)->Unit

    val EditText.string
        get() = this.text.toString()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button.setOnClickListener {
            if(::saveAction.isInitialized) {
                Contact(
                    group = group.string,
                    name = name.string,
                    phone = phone.string,
                    email = email.string,
                    address = address.string
                ).also {
                    saveAction(it)
                }
            }
        }
    }
}
