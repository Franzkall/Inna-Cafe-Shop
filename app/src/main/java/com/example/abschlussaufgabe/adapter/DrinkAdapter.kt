package com.example.abschlussaufgabe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.databinding.ItemImageBinding

class DrinkAdapter(
    private val dataset: List<Drink>
) : RecyclerView.Adapter<DrinkAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val drink = dataset[position]
        holder.binding.imageView.setImageResource(drink.drinkSrc)
    }
}


