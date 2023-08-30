package com.example.abschlussaufgabe.data.model
//SortimentFragment
/**
 * Datenklasse, die Informationen über einen Drink speichert.
 */
data class Drink(
    var cover: Int,        // Das Cover-Bild des Drinks
    var author: String,    // Der Autor des Drinks
    var title: String,     // Der Titel des Drinks
    var description: String, // Die Beschreibung des Drinks
    var id: Int = 0         // Die eindeutige ID des Drinks (Standardwert ist 0)
)

/**
 * Konstante zur Identifizierung des Extra-Keys für die Drink-ID.
 */
const val DRINK_ID_EXTRA = "drinkExtra"
