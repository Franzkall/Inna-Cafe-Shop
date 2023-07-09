package com.example.abschlussaufgabe

import android.content.ClipData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.adapter.ItemAdapter

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var homeAdapter: ItemAdapter
    private lateinit var itemList: List<Int>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        recyclerView = view.findViewById(R.id.home_recycler)


        itemList = createItemList()


        homeAdapter = ItemAdapter(itemList)


        recyclerView.adapter = homeAdapter


        recyclerView.layoutManager = LinearLayoutManager(activity)

        return view
    }


    private fun createItemList(): List<Int> {
        val itemList = mutableListOf<Int>()

        itemList.add(R.drawable.inside)
        itemList.add(R.drawable.bild1)
        itemList.add(R.drawable.bild2)
        itemList.add(R.drawable.bild3)
        itemList.add(R.drawable.bild4)
        itemList.add(R.drawable.lavazza)
        itemList.add(R.drawable.logo)
        itemList.add(R.drawable.logo)

        return itemList
    }
}

