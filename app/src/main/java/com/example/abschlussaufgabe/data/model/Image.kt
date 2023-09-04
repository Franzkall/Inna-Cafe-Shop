package com.example.abschlussaufgabe.data.model

/**
 * Datenklasse, die Informationen über ein Bild und Text speichert.
 */
const val IMAGE_ID_EXTRA = "imageExtra"

data class Image(
    val imageSrc: Int,  // Die Quelle (Resource-ID) des Bildes
    val description: String, // Die Beschreibung des Bildes
    val text: String,        // Der Text des Bildes
    var id: Int = 0          // Die eindeutige ID des Bildes (Standardwert ist 0)
)

/**
 * Fachlicher Kommentar:
 *
 * Diese Datenklasse, `Image`, wird verwendet, um Informationen über Bilder und zugehörigen Text in der App zu speichern.
 * Jedes `Image`-Objekt enthält die Quelle des Bildes (normalerweise als Resource-ID), eine Beschreibung und den Text des Bildes.
 * Diese Informationen werden normalerweise im "CasaFragment" verwendet, um Bilder und dazugehörigen Text dynamisch in der Benutzeroberfläche anzuzeigen.
 * Durch die Verwendung dieser Datenklasse wird die Verwaltung von Bildinformationen in der App vereinfacht und ermöglicht die einfache Anpassung
 * von Bildern und Texten in der Benutzeroberfläche.
 */
