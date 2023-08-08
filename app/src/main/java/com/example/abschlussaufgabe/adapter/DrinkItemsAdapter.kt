package com.example.abschlussaufgabe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.data.model.DrinkItems
import com.example.abschlussaufgabe.databinding.ItemDrinkBinding

class DrinkItemsAdapter : RecyclerView.Adapter<DrinkItemsAdapter.ViewHolder>() {
    private var drinkItems: List<DrinkItems> = mutableListOf()

    fun setDrinkItems(drinks: List<DrinkItems>) {
        this.drinkItems = drinks
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDrinkBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val drinkItem = drinkItems[position]
        holder.bind(drinkItem)
    }

    override fun getItemCount(): Int = drinkItems.size

    class ViewHolder(private val binding: ItemDrinkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(drinkItem: DrinkItems) {
            binding.drinkItem = drinkItem
            binding.executePendingBindings()
        }

    }

}
