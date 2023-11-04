package com.turacican.farkliaktiviteler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.coroutines.NonCancellable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun ChangeActivity(view: View){

        var kullaniciAdi : EditText = findViewById(R.id.tbxExampleName)

        val intent = Intent(applicationContext, SecondActivity::class.java)
        intent.putExtra("User.Name", kullaniciAdi.text.toString())
        startActivity(intent)

    }

}