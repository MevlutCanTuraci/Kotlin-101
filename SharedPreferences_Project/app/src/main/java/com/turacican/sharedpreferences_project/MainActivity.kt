package com.turacican.sharedpreferences_project

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var sharedPerefences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.sharedPerefences = this.getSharedPreferences("com.turacican.sharedpreferences_project", MODE_PRIVATE)

    }


    fun btnSave_click(view: View){
        var textValueObject : EditText = findViewById(R.id.tbxValue)
        val textValue = textValueObject.text.toString()

        if (textValue != ""){

            sharedPerefences.edit().putString("User.Name", textValue).apply()
            Toast.makeText(this, "Değer kaydedildi", Toast.LENGTH_SHORT).show()
        }

        else{
            Toast.makeText(this, "Lütfen bir değer gir", Toast.LENGTH_SHORT).show()
        }

    }


    fun btnShow_click(view: View){
        var textValueObject : EditText = findViewById(R.id.tbxValue)
        var lblResult : TextView = findViewById(R.id.lblResult)
        val textValue = textValueObject.text.toString()

        if (textValue != ""){

            var readingValue = sharedPerefences.getString(textValue, "")

            if (readingValue == "") {
                Toast.makeText(this, "Herhangi bir veri yok", Toast.LENGTH_LONG).show()
                return;
            }

            lblResult.text = "${textValue} anahtarının değeri; ${readingValue}"
        }

        else{
            Toast.makeText(this, "Lütfen bir anahtar değeri gir", Toast.LENGTH_SHORT).show()
        }
    }

    fun btnDelete_click(view: View){

        sharedPerefences.edit().remove("User.Name").apply()
        Toast.makeText(this, "Değer silindi.", Toast.LENGTH_SHORT).show()
    }


}