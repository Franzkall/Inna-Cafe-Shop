package com.example.abschlussaufgabe.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.clicklistener.DrinkClickListener
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.databinding.HotAndColdBinding

// Dieser View Holder wird verwendet, um Getränke im RecyclerView anzuzeigen.

class DrinkViewHolder(
    private val hotAndColdBinding: HotAndColdBinding, // Das Binding-Objekt für die Getränkeansicht.
    private val drinkClickListener: DrinkClickListener, // Ein Listener für Getränke-Klicks.
) : RecyclerView.ViewHolder(hotAndColdBinding.root) {

    // Diese Methode bindet Getränkedaten an die Ansicht im ViewHolder.
    fun bindDrink(drink: Drink) {

        hotAndColdBinding.coverItem.setImageResource(drink.cover) // Das Coverbild des Getränks.
        hotAndColdBinding.titleItem.text = drink.title // Der Titel des Getränks.
        hotAndColdBinding.authorItem.text = drink.author // Der Autor des Getränks.

        // Ein Klicklistener wird auf die Kartenansicht angewendet.
        hotAndColdBinding.cardView.setOnClickListener {
            drinkClickListener.onClick(drink) // Der Klick wird an den Listener weitergegeben.
        }
    }
}
