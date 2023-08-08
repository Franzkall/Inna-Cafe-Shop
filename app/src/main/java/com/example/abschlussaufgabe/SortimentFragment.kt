package com.example.abschlussaufgabe

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.abschlussaufgabe.adapter.DrinkAdapter
import com.example.abschlussaufgabe.data.model.DRINK_ID_EXTRA
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.databinding.FragmentSortimentBinding
import com.example.abschlussaufgabe.repository.Repository


class SortimentFragment : Fragment() {

    private lateinit var binding: FragmentSortimentBinding
    private val drinkAdapter: DrinkAdapter by lazy { DrinkAdapter(Repository.drinkList, this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSortimentBinding.inflate(inflater, container, false)

        binding.rvSpecial.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = drinkAdapter
        }

        return binding.root
    }

    fun onClick(drink: Drink) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(DRINK_ID_EXTRA, drink.id)
        startActivity(intent)
    }
}
