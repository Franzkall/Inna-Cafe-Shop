package com.example.abschlussaufgabe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abschlussaufgabe.adapter.ImageAdapter
import com.example.abschlussaufgabe.data.DataSource
import com.example.abschlussaufgabe.databinding.FragmentCasaBinding

class CasaFragment : Fragment() {

    private lateinit var binding: FragmentCasaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCasaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = DataSource().loadImages()

        binding.imagesRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.imagesRecyclerview.adapter = ImageAdapter(imageList)
    }
}
