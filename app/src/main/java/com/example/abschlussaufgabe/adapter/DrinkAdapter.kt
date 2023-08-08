package com.example.abschlussaufgabe.adapter

import com.example.abschlussaufgabe.ui.SortimentFragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.databinding.HotAndColdBinding


class DrinkAdapter(
    private val drinks: List<Drink>,
    private val drinkClickListener: SortimentFragment
) : RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val binding = HotAndColdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DrinkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bindDrink(drinks[position])
    }

    override fun getItemCount(): Int = drinks.size

    inner class DrinkViewHolder(private val binding: HotAndColdBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindDrink(drink: Drink) {
            binding.coverItem.setImageResource(drink.cover)
            binding.titleItem.text = drink.title
            binding.authorItem.text = drink.author

            binding.cardView.setOnClickListener {
                drinkClickListener.onClick(drink)
            }
        }
    }
}
