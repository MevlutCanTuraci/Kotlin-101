package com.turacican.superkahramankitabi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class KahramanDetaylari : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kahraman_detaylari)

        var intent = intent

        val heroName : TextView = findViewById(R.id.lblHeroDetail_Name)
        val heroDesc : TextView = findViewById(R.id.lblHeroDetail_Description)

        heroName.text = intent.getStringExtra("Hero-Name").toString()
        heroDesc.text = intent.getStringExtra("Hero-Detail").toString()

    }
}