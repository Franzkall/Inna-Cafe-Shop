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
import com.example.abschlussaufgabe.adapter.DrinkItemsAdapter
import com.example.abschlussaufgabe.databinding.FragmentMoneyBinding
import com.example.abschlussaufgabe.viewholder.MoneyFragmentViewModel

// Dieses Fragment zeigt eine Liste von Getränken mit Preisen an.

class MoneyFragment : Fragment() {

    private val TAG: String = "DRINK_LIST"

    private val viewModel: MoneyFragmentViewModel by viewModels()

    private lateinit var binding: FragmentMoneyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_money, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialisierung des ViewModels und Adapters.

        // Der RecyclerView wird mit dem Adapter verbunden.
        val recyclerView: RecyclerView = binding.recyclerView2

        val activity: MainActivity = requireActivity() as MainActivity
        activity.toolbarTitle.text = "Preisliste"

        // Beobachtung der Getränkeliste im ViewModel, um den Adapter zu aktualisieren.
        viewModel.drinks.observe(viewLifecycleOwner, Observer { drinks ->

            recyclerView.adapter = DrinkItemsAdapter(drinks)
        })


    }

    }

