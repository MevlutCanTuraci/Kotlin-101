package com.example.navigationkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    //Butun tasarım yüklendikten sonra çalışır.
    //doğru kullanımı bu şekildedir.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button : Button = view.findViewById(R.id.button1)
        val lblUsername : TextView = view.findViewById(R.id.lblUsername_fg2)

        var isThereArgs = false

        //Arguman varsa buraya girer.
        arguments?.let {
            val kullaniciAdi = SecondFragmentArgs.fromBundle(it).username
            lblUsername.text = "Kullanıcı adınız: ${kullaniciAdi}"

            isThereArgs = true
        }

        if (!isThereArgs) lblUsername.text = "Kullanıcı adı bilgisi gelmedi :("

        button.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment2()
            Navigation.findNavController(it).navigate(action)
        }
    }


}