package com.example.abschlussaufgabe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.data.model.DrinkItems
import com.example.abschlussaufgabe.databinding.ItemDrinkBinding

//

/**
 * Adapter-Klasse, die DrinkItems in einer RecyclerView anzeigt.
 */
class DrinkItemsAdapter(private val drinkItems: List<DrinkItems>) : RecyclerView.Adapter<DrinkItemsAdapter.ViewHolder>() {

    /**
     * Erstellt eine neue ViewHolder-Instanz.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDrinkBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    /**
     * Bindet Daten an einen ViewHolder.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val drinkItem = drinkItems[position]
        holder.bind(drinkItem)
    }

    /**
     * Gibt die Anzahl der DrinkItems zurück.
     */
    override fun getItemCount(): Int = drinkItems.size

    /**
     * ViewHolder-Klasse, die die Darstellung eines DrinkItems verwaltet.
     */
    class ViewHolder(private val binding: ItemDrinkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Bindet ein DrinkItem an den ViewHolder.
         */
        fun bind(drinkItem: DrinkItems) {
            binding.drinkItem = drinkItem // Setzt das DrinkItem im Binding
            binding.executePendingBindings() // Erzwingt die Ausführung der Bindings
        }
    }
}

/**
 * Fachlicher Kommentar:
 *
 * Der DrinkItemsAdapter ist eine wichtige Komponente in der RecyclerView-Ansicht der App. Er dient
 * dazu, DrinkItems in einer scrollbaren Liste anzuzeigen. Ein DrinkItem kann verschiedene Informationen
 * zu einem Getränk enthalten, und dieser Adapter ermöglicht die Darstellung dieser Informationen in
 * der Benutzeroberfläche. Dieser Adapter wird in verschiedenen Teilen der App verwendet, um
 * Getränkeinformationen anzuzeigen.
 */
