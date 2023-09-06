package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.activities.MainActivity
import com.example.abschlussaufgabe.adapter.DrinkItemsAdapter
import com.example.abschlussaufgabe.data.model.DrinkItems
import com.example.abschlussaufgabe.data.model.PriceListData
import com.example.abschlussaufgabe.databinding.FragmentMoneyBinding
import com.example.abschlussaufgabe.viewmodel.MoneyFragmentViewModel
import com.example.abschlussaufgabe.viewmodel.RefreshmentViewModel

class MoneyFragment : Fragment() {

    // ViewModel für dieses Fragment
    private val viewModel: MoneyFragmentViewModel by viewModels()
    private val refreshmentViewModel: RefreshmentViewModel by viewModels()

    // Binding-Objekt für das Fragment
    private lateinit var binding: FragmentMoneyBinding

    /**
     * Wird aufgerufen, um die View für das Fragment zu erstellen.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_money, container, false)
        return binding.root
    }

    /**
     * Wird aufgerufen, nachdem die View des Fragments erstellt wurde.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.stephan()
        refreshmentViewModel.benjamin()

        // Initialisierung des ViewModels und Adapters.
        // Der RecyclerView wird mit dem Adapter verbunden.
        binding.recyclerView2

        // Erzeuge eine Toast-Nachricht
        val toast = Toast.makeText(requireContext(), " Preisliste wird geladen...", Toast.LENGTH_SHORT)

        // Setze die Gravitation (Position) des Toasts
        toast.setGravity(Gravity.CENTER_VERTICAL, 600, 600) // Hier wird die Gravitation auf die Mitte des Bildschirms gesetzt

        // Zeige den Toast an
        toast.show()

        // Toolbar-Titel wird aktualisiert
        val activity: MainActivity = requireActivity() as MainActivity
        activity.toolbarTitle.text = "Preisliste"



        // Beobachtung der Getränkeliste im ViewModel, um den Adapter zu aktualisieren.
        viewModel.drinks.observe(viewLifecycleOwner, Observer { drinks ->

            // Die Preisliste-Daten aus den Getränkedaten erstellen und in die Datenbank einfügen.
            //createPriceListData(drinks)

            // Den RecyclerView-Adapter mit den Getränkedaten aktualisieren.
            binding.recyclerView2.adapter = DrinkItemsAdapter(drinks)
        })
    }

    /**
     * Erstellt Preisliste-Daten aus den Getränkedaten und fügt sie in die Datenbank ein.
     *
     * @param drinks Die Liste der Getränkedaten.
     */
    /* private fun createPriceListData(drinks: List<DrinkItems>) {
        val priceListData = mutableListOf<PriceListData>()
        for ((id, drink) in drinks.withIndex()) {
            val item = PriceListData(id = id.toLong(), itemName = drink.drink, price = drink.price.toDouble())
            priceListData.add(item)
        }
        insertIntoDatabase(priceListData)
    }*/

    /**
     * Fügt die erstellten Preisliste-Daten in die Datenbank ein.
     *
     * @param priceListData Die Liste der Preisliste-Daten.
     */
    private fun insertIntoDatabase(priceListData: List<PriceListData>) {
        refreshmentViewModel.insertAllRefreshment(priceListData)
    }
}

/** Fachlicher Kommentar: Dieses Fragment zeigt eine Preisliste von Getränken an und aktualisiert sie mithilfe eines Adapters. Die Getränkeinformationen werden aus dem ViewModel abgerufen und in der Preisliste angezeigt. Es besteht die Möglichkeit, Preisdaten aus den Getränkeinformationen zu erstellen und sie in die Datenbank einzufügen, was jedoch derzeit auskommentiert ist. */
