package com.turacican.kotlinoop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lblExample: TextView = findViewById(R.id.textView)

        var superHero = SuperHero(name = "Mevlüt", age = 20, job = "Developer")
        lblExample.text = superHero.Getir()


    }

}