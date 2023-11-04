package com.example.fragments_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun firstFragment_click(view : View){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment = BlankFragment()

        fragmentTransaction.replace(R.id.frameLayout, firstFragment).commit()

    }

    fun secondFragment_click(view : View){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment = BlankFragment2()

        fragmentTransaction.replace(R.id.frameLayout, firstFragment).commit()
    }

}