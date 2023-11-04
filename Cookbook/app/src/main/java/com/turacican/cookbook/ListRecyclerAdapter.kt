package com.turacican.cookbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListRecyclerAdapter(val cookList: ArrayList<String>, val cookIdList : ArrayList<Int>) : RecyclerView.Adapter<ListRecyclerAdapter.CookHolder>() {

    class CookHolder(itemView : View) : RecyclerView.ViewHolder(itemView){



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CookHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row, parent, false)
        return CookHolder(view)
    }

    override fun getItemCount(): Int {
        return cookList.size
    }

    override fun onBindViewHolder(holder: CookHolder, position: Int) {
        val textObject = holder.itemView.findViewById<TextView>(R.id.recycler_row_text)
        textObject.text = cookList[position]

        holder.itemView.setOnClickListener {

        }
    }

}