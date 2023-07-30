package com.example.abschlussaufgabe.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.clicklistener.DrinkClickListener
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.databinding.HotAndColdBinding

class DrinkViewHolder (
    hotAndColdBinding: HotAndColdBinding,
    private val clickListener: DrinkClickListener

) : RecyclerView.ViewHolder(hotAndColdBinding.root) {

    fun bindDrink(drink: Drink) {


    }
}
