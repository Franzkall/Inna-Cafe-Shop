package com.example.abschlussaufgabe.data.model

// ViewFragment
/**
 * Datenklasse für eine Panoramaansicht.
 */
data class Panoramic(
    val name: String,       // Name der Stadt
    val img: Int,           // Ressourcen-ID des Bildes der Stadt
    val population: String  // Bevölkerungszahl der Stadt
)

/**
 * Fachlicher Kommentar:
 *
 * Diese Datenklasse, `Panoramic`, wird verwendet, um Informationen über Panoramaansichten von Städten in der App zu speichern.
 * Jedes `Panoramic`-Objekt enthält den Namen der Stadt, die Ressourcen-ID des Bildes der Stadt und die Bevölkerungszahl der Stadt.
 * Diese Informationen werden normalerweise im "ViewFragment" verwendet, um Panoramaansichten von verschiedenen Städten anzuzeigen.
 * Die Verwendung dieser Datenklasse erleichtert die Verwaltung und Anzeige von Panoramaansichten in der App.
 */
