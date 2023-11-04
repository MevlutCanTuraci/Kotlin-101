package com.turacican.cookbook

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment() {


    var cookNameLists = ArrayList<String>()
    var cookIdLists = ArrayList<Int>()
    private lateinit var listAdapter : ListRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycletViewList : RecyclerView = view.findViewById(R.id.recyclerView)

        recycletViewList.layoutManager = LinearLayoutManager(requireContext())
        listAdapter = ListRecyclerAdapter(cookNameLists, cookIdLists)
        recycletViewList.adapter = listAdapter


        GetCooks(view)
    }

    fun GetCooks(view: View){

        try {

            context?.let {
                val db = it.openOrCreateDatabase("cooks", Context.MODE_PRIVATE, null)

                //COOKNAME, COOKDETAIL, COOKIMAGE, ID

                val cursor = db.rawQuery("SELECT * FROM Cooks", null)
                val cookNameIndex = cursor.getColumnIndex("COOKNAME")
                val cookIdIndex = cursor.getColumnIndex("ID")

                cookNameLists.clear()
                cookIdLists.clear()

                while (cursor.moveToNext()){
                    cookNameLists.add(cursor.getString(cookNameIndex))
                    cookIdLists.add(cursor.getInt(cookIdIndex))
                }

                listAdapter.notifyDataSetChanged()

                cursor.close()

            }


        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }

}