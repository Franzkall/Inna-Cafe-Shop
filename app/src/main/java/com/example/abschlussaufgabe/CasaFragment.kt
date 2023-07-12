package com.example.abschlussaufgabe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CasaFragment : Fragment() {


    class CasaFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val rootView = inflater.inflate(R.layout.fragment_casa, container, false)

            val images = listOf(
                Image(R.drawable.bild1),
                Image(R.drawable.inside),
                Image(R.drawable.bild4),
                Image(R.drawable.caffe),
                Image(R.drawable.new_logo),
                Image(R.drawable.lavazza)
            )

            val recyclerView = rootView.findViewById<RecyclerView>(R.id.imagesRecyclerview)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = ImageAdapter(requireContext(), images)

            return rootView
        }
    }



}
