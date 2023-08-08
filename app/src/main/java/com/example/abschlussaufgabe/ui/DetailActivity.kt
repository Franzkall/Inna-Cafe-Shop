package com.example.abschlussaufgabe.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.abschlussaufgabe.data.model.DRINK_ID_EXTRA
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.data.model.drinkList
import com.example.abschlussaufgabe.databinding.ActivityDetailBinding

// Diese Aktivität zeigt Details zu einem ausgewählten Getränk an.

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Das Layout für die Aktivität wird aufgeblasen und das Binding-Objekt initialisiert.
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Die ID des ausgewählten Getränks wird aus den Intent-Extras gelesen.
        val drinkId = intent.getIntExtra(DRINK_ID_EXTRA, -1)

        // Das entsprechende Getränk wird anhand der ID aus der Liste geladen.
        val drink = drinkFromId(drinkId)
        if (drink != null) {
            // Die Detailansicht wird mit Informationen über das Getränk aktualisiert.
            binding.cover.setImageResource(drink.cover)
            binding.title.text = drink.title
            binding.description.text = drink.description
            binding.author.text = drink.author
        }
    }

    // Diese Methode sucht nach einem Getränk in der Liste basierend auf seiner ID.
    private fun drinkFromId(drinkId: Int): Drink? {
        for (drink in drinkList) {
            if (drink.id == drinkId)
                return drink
        }
        return null
    }
}
