package com.example.abschlussaufgabe.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.clicklistener.DrinkClickListener
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.databinding.HotAndColdBinding

class DrinkViewHolder(
    private val hotAndColdBinding: HotAndColdBinding,
    private val drinkClickListener: DrinkClickListener,
) : RecyclerView.ViewHolder(hotAndColdBinding.root) {

    fun bindDrink(drink: Drink) {

        hotAndColdBinding.coverItem.setImageResource(drink.cover)
        hotAndColdBinding.titleItem.text = drink.title
        hotAndColdBinding.authorItem.text = drink.author

        hotAndColdBinding.cardView.setOnClickListener {
            drinkClickListener.onClick(drink)
        }

    }
}