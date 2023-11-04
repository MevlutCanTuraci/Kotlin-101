package com.turacican.contextproject

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun ShowClick(view : View){
        ShowAlert(view)
        //Toast.makeText(this@MainActivity, "Selam, Hoşgeldin", Toast.LENGTH_LONG).show()
    }


    fun ShowAlert(view: View){

        var uyariMesaji = AlertDialog.Builder(this)
        uyariMesaji.setTitle("Şifre Hatası!")
        uyariMesaji.setMessage("Şifrenizi girmediniz! Tekrar denemek ister misiniz?")

        uyariMesaji.setPositiveButton("Evet, isterim", DialogInterface.OnClickListener { dialogInterface, i ->
            Toast.makeText(this, "Tekrar deneyeceksiniz.", Toast.LENGTH_SHORT).show()
        })

        uyariMesaji.setNegativeButton("Hayır") {dialogInterface, i ->
            Toast.makeText(this, "Hayırı seçtiniz.", Toast.LENGTH_SHORT).show()
        }

        uyariMesaji.show()
    }


}