package com.turacican.handlerrunnableprojesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var runnable : Runnable = Runnable { }
    var handler = Handler(Looper.myLooper()!!)
    var count = 0

    lateinit var lblResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lblResult = findViewById(R.id.lblSayacCount)
    }


    fun btnStop_click(view : View){

        handler.removeCallbacks(runnable)
        count = 0

    }


    fun btnStart_click(view : View){

        count = 0
        runnable = object: Runnable {

            override fun run() {
                count++
                lblResult.text = "Sayaç: ${count}"
                handler.postDelayed(runnable, 1000)
            }
        }

        handler.post(runnable)

    }
}