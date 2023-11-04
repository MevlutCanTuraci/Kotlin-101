package com.example.navigationkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation

class FirstFragment : Fragment() {
       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    //Butun tasarım yüklendikten sonra çalışır.
    //doğru kullanımı bu şekildedir.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button : Button = view.findViewById(R.id.btnNext_fg1)
        val usernameTbx : EditText = view.findViewById(R.id.tbxUserName_fg1)

        button.setOnClickListener {
            val username = usernameTbx.text.toString()

            //Burada SecondFragment'teki argumanımıza karşılık gelen,
            // username değişkenini gönderiyoruz
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(username)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


}