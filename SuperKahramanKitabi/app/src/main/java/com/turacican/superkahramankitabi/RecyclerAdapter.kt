package com.turacican.superkahramankitabi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val kahramanListesi : ArrayList<String>, val kahramanDetaylari : ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.KahramanVH>() {

    class KahramanVH(itemView : View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KahramanVH {
        //Inflater, Layout Inflater, Menu Inflater
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyler_row, parent, false)
        return KahramanVH(itemView)
    }

    override fun onBindViewHolder(holder: KahramanVH, position: Int) {

        val heroName : TextView = holder.itemView.findViewById<TextView>(R.id.lblHeroName)
        val heroDetail : TextView = holder.itemView.findViewById<TextView>(R.id.lblDetail)

        heroName.text = kahramanListesi.get(position)
        heroDetail.text = "${kahramanDetaylari.get(position).substring(0, 10)}..."

        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, KahramanDetaylari::class.java)
            intent.putExtra("Hero-Name", kahramanListesi.get(position))
            intent.putExtra("Hero-Detail", kahramanDetaylari.get(position))

            holder.itemView.context.startActivity(intent)
        }
    }

    //Main listenin count değerini veriyoruz.
    override fun getItemCount(): Int {
        return kahramanListesi.size
    }
}