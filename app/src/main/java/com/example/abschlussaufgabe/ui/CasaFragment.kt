package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abschlussaufgabe.adapter.ImageAdapter
import com.example.abschlussaufgabe.data.DataSource
import com.example.abschlussaufgabe.databinding.FragmentCasaBinding

// Dieses Fragment zeigt eine Liste von Bildern im RecyclerView an.

class CasaFragment : Fragment() {

    private lateinit var binding: FragmentCasaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Das Layout für dieses Fragment wird aufgeblasen und das Binding-Objekt initialisiert.
        binding = FragmentCasaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Eine Liste von Bildern wird aus der DataSource geladen.
        val imageList = DataSource().loadImages()

        // Der RecyclerView wird ein LayoutManager zugewiesen und ein Adapter mit der Bildliste.
        binding.imagesRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.imagesRecyclerview.adapter = ImageAdapter(imageList)
    }
}
