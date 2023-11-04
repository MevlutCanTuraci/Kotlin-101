package com.turacican.farkliaktiviteler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var mainLabel : TextView = findViewById(R.id.lblMain)

        val intent = intent
        mainLabel.text = intent.getStringExtra("User.Name")

    }
}