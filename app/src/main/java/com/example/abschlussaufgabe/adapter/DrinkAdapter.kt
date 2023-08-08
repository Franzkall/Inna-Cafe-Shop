package com.example.abschlussaufgabe.adapter

import com.example.abschlussaufgabe.ui.SortimentFragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.databinding.HotAndColdBinding

// Adapter-Klasse, die Drinks in einer RecyclerView anzeigt
class DrinkAdapter(
    private val drinks: List<Drink>,                 // Liste der anzuzeigenden Drinks
    private val drinkClickListener: SortimentFragment // Listener für Klick-Ereignisse auf Drinks
) : RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>() {

    // Erstellt neue ViewHolder-Instanz
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val binding = HotAndColdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DrinkViewHolder(binding)
    }

    // Bindet Daten an einen ViewHolder
    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bindDrink(drinks[position])
    }

    // Gibt die Anzahl der Drinks zurück
    override fun getItemCount(): Int = drinks.size

    // ViewHolder-Klasse, die die Darstellung eines Drinks verwaltet
    inner class DrinkViewHolder(private val binding: HotAndColdBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Bindet einen Drink an den ViewHolder
        fun bindDrink(drink: Drink) {
            binding.coverItem.setImageResource(drink.cover) // Setzt das Cover-Bild des Drinks
            binding.titleItem.text = drink.title             // Setzt den Titel des Drinks
            binding.authorItem.text = drink.author           // Setzt den Autor des Drinks

            // Fügt einen Klick-Listener zum CardView hinzu, um auf Drink-Klicks zu reagieren
            binding.cardView.setOnClickListener {
                drinkClickListener.onClick(drink) // Ruft die Methode auf, wenn ein Drink geklickt wird
            }
        }
    }
}
