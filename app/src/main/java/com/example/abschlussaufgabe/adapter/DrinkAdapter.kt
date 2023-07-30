package com.example.abschlussaufgabe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.clicklistener.DrinkClickListener
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.databinding.HotAndColdBinding
import com.example.abschlussaufgabe.viewholder.DrinkViewHolder

class DrinkAdapter(
    private val drinks: List<Drink>,
    private val clickListener: DrinkClickListener
) : RecyclerView.Adapter<DrinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HotAndColdBinding.inflate(inflater, parent, false)
        return DrinkViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val drink = drinks[position] // Holen Sie sich das aktuelle Drink-Objekt aus der Liste
        holder.bindDrink(drink) // Übergabe des Drink-Objekts an den ViewHolder
    }

    override fun getItemCount(): Int = drinks.size
}
