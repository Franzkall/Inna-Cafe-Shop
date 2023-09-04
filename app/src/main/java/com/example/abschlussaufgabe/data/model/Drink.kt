package com.example.abschlussaufgabe.data.model

// SortimentFragment
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

/** Fachlicher Kommentar:

In dieser Datei wird die Datenklasse Drink definiert, die Informationen über Getränke speichert, die im Sortiment der App angezeigt werden. Jedes Drink-Objekt enthält Angaben wie das Cover-Bild des Getränks, den Autor, den Titel, die Beschreibung und eine eindeutige ID. Diese Informationen sind entscheidend, um die Details eines ausgewählten Getränks in der App anzuzeigen.

Die konstante Variable DRINK_ID_EXTRA wird ebenfalls definiert und dient dazu, den Schlüssel für die Getränk-ID in Intent-Extras zu identifizieren. Dies ist nützlich, wenn zwischen Aktivitäten oder Fragmenten gewechselt wird und Informationen über ein ausgewähltes Getränk übertragen werden müssen.*/