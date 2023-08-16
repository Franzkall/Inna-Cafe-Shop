package com.example.abschlussaufgabe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.databinding.FragmentViewBinding
import com.example.abschlussaufgabe.viewmodel.CityViewModel


class ViewFragment : Fragment() {
    private val model: CityViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewBinding.inflate(inflater, container, false)
        val view = binding.root

        val activity: MainActivity = requireActivity() as MainActivity
        activity.toolbarTitle.text = "Panoramic"


        model.getCityData().observe(viewLifecycleOwner, Observer { city ->
            binding.cityImage.setImageDrawable(
                ResourcesCompat.getDrawable(resources, city.img, requireContext().theme)
            )
            binding.CityNameTV.text = city.name
            binding.cityStringTV.text = city.population.toString()
        })

        return view
    }

}