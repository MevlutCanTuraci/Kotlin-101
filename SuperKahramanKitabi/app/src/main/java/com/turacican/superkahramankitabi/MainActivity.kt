package com.turacican.superkahramankitabi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var superKahramanIsimleri = ArrayList<String>()
        superKahramanIsimleri.add("Batman")
        superKahramanIsimleri.add("Superman")
        superKahramanIsimleri.add("Ironman")
        superKahramanIsimleri.add("Aquaman")


        var superKahramanDetay= ArrayList<String>()
        superKahramanDetay.add("Yarasa adamdır")
        superKahramanDetay.add("Bütün güçlere sahiptir ve gezegen taşır")
        superKahramanDetay.add("Demir adamdır ve zekidir")
        superKahramanDetay.add("Suya hükmeder")

        val rc: RecyclerView = findViewById(R.id.recyclerView)

        var adapter = RecyclerAdapter(superKahramanIsimleri, superKahramanDetay)

        //Verilerin alt altta listelenmesi için yazdık
        var layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rc.adapter = adapter
        rc.layoutManager = layoutManager




    }
}