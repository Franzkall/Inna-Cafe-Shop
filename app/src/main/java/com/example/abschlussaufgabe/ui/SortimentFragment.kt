package com.example.abschlussaufgabe.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.adapter.DrinkAdapter
import com.example.abschlussaufgabe.data.model.DRINK_ID_EXTRA
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.databinding.FragmentSortimentBinding
import com.example.abschlussaufgabe.repository.Repository
import com.example.abschlussaufgabe.util.ToolbarTextUpdater

// Hot_and_Cold
// Dieses Fragment zeigt eine Auswahl von Getränken im Sortiment an.

class SortimentFragment : Fragment() {

    private lateinit var binding: FragmentSortimentBinding
    private val drinkAdapter: DrinkAdapter by lazy { DrinkAdapter(Repository.drinkList, this) }
    private lateinit var toolbarTextUpdater: ToolbarTextUpdater

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ToolbarTextUpdater) {
            toolbarTextUpdater = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSortimentBinding.inflate(inflater, container, false)

        val activity =  requireActivity() as MainActivity
        activity.toolbarTitle.text = "Specials"


        // Der RecyclerView für das Sortiment wird konfiguriert.
        binding.rvSpecial.apply {
            layoutManager = GridLayoutManager(requireContext(), 3) // GridLayoutManager mit 3 Spalten.
            adapter = drinkAdapter
        }

        return binding.root
    }

    // Diese Methode wird aufgerufen, wenn ein Getränk im Sortiment angeklickt wird.
    fun onClick(drink: Drink) {
        Log.e("Sortiment","${drink.id}")
        // Eine Intent wird erstellt, um zur DetailActivity zu navigieren und die Getränk-ID zu übergeben.
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(DRINK_ID_EXTRA, drink.id)
        startActivity(intent)
    }
}
