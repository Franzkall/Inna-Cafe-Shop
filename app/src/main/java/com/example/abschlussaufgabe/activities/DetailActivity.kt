package com.example.abschlussaufgabe.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import com.example.abschlussaufgabe.data.model.DRINK_ID_EXTRA
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.databinding.ActivityDetailBinding
import com.example.abschlussaufgabe.repository.Repository.drinkList

/**
 * Diese Aktivität zeigt Details zu einem ausgewählten Getränk an.
 */
class DetailActivity : AppCompatActivity() {

    // Binding-Objekt für die Aktivität
    private lateinit var binding: ActivityDetailBinding

    /**
     * Wird aufgerufen, wenn die Aktivität erstellt wird.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Das Layout für die Aktivität wird aufgeblasen und das Binding-Objekt initialisiert.
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Klick-Listener für den Pfeil-Button zum Zurücknavigieren
        binding.ivArrow.setOnClickListener {
            // Mit dem Navigation Controller zurücknavigieren
            binding.ivArrow.findNavController().navigateUp()
        }

        // Die ID des ausgewählten Getränks wird aus den Intent-Extras gelesen.
        val drinkId = intent.getIntExtra(DRINK_ID_EXTRA, 1)

        // Das entsprechende Getränk wird anhand der ID aus der Liste geladen.
        val drink = drinkFromId(drinkId)
        Log.e("Detail", "Ausgewähltes Getränk: $drink")
        if (drink != null) {
            // Die Detailansicht wird mit Informationen über das Getränk aktualisiert.
            binding.cover.setImageResource(drink.cover)
            binding.title.text = drink.title
            binding.description.text = drink.description
            binding.author.text = drink.author

            // Debug-Log für Getränkdetails
            Log.e(
                "Drinktitel: ${drink.title} Drink description: ${drink.description} Drink author: ${drink.author}",
                "Beobachtung von Fehlern"
            )
        }
    }

    /**
     * Diese Methode sucht nach einem Getränk in der Liste basierend auf seiner ID.
     */
    private fun drinkFromId(drinkId: Int): Drink? {
        Log.e("Detail", "Größe der Getränkeliste: ${drinkList.size}")
        for (drink in drinkList) {
            if (drink.id == drinkId)
                return drink
        }
        return null
    }
}
