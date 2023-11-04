  package com.turacican.kotlinsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{

            val veritabani = this.openOrCreateDatabase("ExampleDb", MODE_PRIVATE, null)
            veritabani.execSQL("CREATE TABLE IF NOT EXISTS Urunler (Id INTEGER PRIMARY KEY, Name VARCHAR, Price INT)")
            

        }
        catch (e: Exception){

        }

    }
}