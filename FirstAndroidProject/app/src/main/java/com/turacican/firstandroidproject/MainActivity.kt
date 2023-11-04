package com.turacican.firstandroidproject

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Diziler;

//        val _array = arrayListOf<String>()
//        _array.add("mevlüt")
//        _array.add("can")
//        _array.add("turacı")
//
//        for (item in _array){
//            println("item adı: " + item)
//        }

//        var mapim = hashMapOf<String, String>()
//        mapim.put("Audi", "200 KM/S")
//        mapim.put("Toyota", "295 KM/S")
//        mapim.put("Bently", "255 KM/S")
//
//
//        println(mapim.get("Toyota"))

        var not = 5
        var notResult = ""

        when(not)
        {
            0 -> notResult = "Kaldınız"
            1 -> notResult = "Geçtiniz"
            2 -> notResult = "Geçtiniz"
            3 -> notResult = "İyi ile geçtiniz"
            4 -> notResult = "Çok iyi ile geçtiniz"
            5 -> notResult = "Pek iyi ile geçtiniz :)"

        }

        println(notResult)

    }


    fun ChangeName(view: View){
        val lblExample: TextView = findViewById(R.id.lblExample)
        lblExample.text = "Mevlüt Can Turacı"

    }

}