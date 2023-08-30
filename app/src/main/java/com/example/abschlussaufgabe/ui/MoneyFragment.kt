package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.activities.MainActivity
import com.example.abschlussaufgabe.adapter.DrinkItemsAdapter
import com.example.abschlussaufgabe.databinding.FragmentMoneyBinding
import com.example.abschlussaufgabe.viewmodel.MoneyFragmentViewModel

/**
 * Dieses Fragment zeigt eine Liste von Getränken mit Preisen an.
 */
class MoneyFragment : Fragment() {

    // ViewModel für dieses Fragment
    private val viewModel: MoneyFragmentViewModel by viewModels()

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

        // Initialisierung des ViewModels und Adapters.

        // Der RecyclerView wird mit dem Adapter verbunden.
        val recyclerView: RecyclerView = binding.recyclerView2


        // Toolbar-Titel wird aktualisiert
        val activity: MainActivity = requireActivity() as MainActivity
        activity.toolbarTitle.text = "Preisliste"

        // Beobachtung der Getränkeliste im ViewModel, um den Adapter zu aktualisieren.
        viewModel.drinks.observe(viewLifecycleOwner, Observer { drinks ->
            // Den ViewFlipper ausblenden, nachdem die Daten geladen wurden.

            recyclerView.adapter = DrinkItemsAdapter(drinks)
        })
    }
}
