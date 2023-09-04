package com.example.abschlussaufgabe.data.model

// MoneyFragment
/**
 * Datenklasse, die Informationen über ein Drink-Item speichert.
 */
data class DrinkItems(
    val drink: String,       // Der Name des Drinks
    val price: String,       // Der Preis des Drinks
    val description: String  // Die Beschreibung des Drinks
)

/**
 * Fachlicher Kommentar:
 *
 * Diese Datenklasse, `DrinkItems`, wird verwendet, um Informationen über einzelne Getränke-Items zu speichern.
 * Jedes `DrinkItems`-Objekt enthält den Namen des Getränks, den Preis und eine Beschreibung. Diese Informationen
 * werden normalerweise verwendet, um die Preisliste von Getränken in der App darzustellen, beispielsweise im
 * "MoneyFragment". Durch die Verwendung dieser Datenklasse wird die Struktur und Verwaltung von Getränkeinformationen
 * vereinfacht und erleichtert die Aktualisierung und Anzeige von Getränke-Items in der Benutzeroberfläche.
 */
