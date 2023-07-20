package com.example.abschlussaufgabe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abschlussaufgabe.adapter.DrinkAdapter
import com.example.abschlussaufgabe.data.DataSource
import com.example.abschlussaufgabe.databinding.FragmentSortimentBinding


class SortimentFragment : Fragment() {
        private lateinit var binding: FragmentSortimentBinding

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentSortimentBinding.inflate(inflater,container,false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val drinkList = DataSource().loadDrinks()

         binding.rvSpecial.layoutManager = LinearLayoutManager(requireContext())
            binding.rvSpecial.adapter = DrinkAdapter(drinkList)

        }
}