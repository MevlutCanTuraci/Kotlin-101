package com.turacican.superheroproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun SuperHeroCreate(view: View){
        var heroName    = findViewById<EditText>(R.id.tbxSuperHeroName).text.toString()
        var heroAge     = findViewById<EditText>(R.id.tbxSuperHeroAge).text.toString().toIntOrNull() ?: 0
        var heroJob     = findViewById<EditText>(R.id.tbxSuperHeroJob).text.toString()
        var result      = findViewById<TextView>(R.id.lblResult)


        if (heroAge <= 0){
            result.text = "Yaş değerini lütfen numeric ve pozitif bir değer giriniz!"
            return
        }

        Log.d("App", heroName)
        result.text = "Isim: ${heroName}\r\nYaş: ${heroAge}\r\nMeslek: ${heroJob}"
    }

}