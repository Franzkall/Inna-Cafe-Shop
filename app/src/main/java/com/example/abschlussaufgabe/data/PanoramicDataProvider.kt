package com.example.abschlussaufgabe.data

import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Panoramic

// ViewFragment

/**
 * Klasse, die Bildertedaten bereitstellt.
 */
class PanoramicDataProvider {

    private val picture = arrayListOf<Panoramic>()

    /**
     * Initialisierung der Bilderdaten.
     */
    init {
        picture.add(Panoramic("London", R.drawable.g1, "Ecco ksksksksksks, skdkkskffjf, kfnfjfjfnfjfj, djfnfjffjf, dhfjfnfh"))
        picture.add(Panoramic("London", R.drawable.g5, "Ecco"))
        picture.add(Panoramic("Mailand", R.drawable.g3, "Allora"))
        picture.add(Panoramic("Mailand", R.drawable.g4, "Andiamo"))
    }

    /**
     * Gibt die Liste der Bilder zurück.
     */
    fun getPictures() = picture
}
/**
 * Fachlicher Kommentar:
 *
 * Die Datenklasse `User` dient zur Speicherung von Benutzerinformationen in der App.
 * Jedes `User`-Objekt enthält eine eindeutige Benutzer-ID, den Namen des Benutzers und seine Punktzahl oder Bewertung.
 * Diese Informationen werden normalerweise im "RegisterFragment" verwendet, um Benutzerdaten zu erfassen und zu verarbeiten.
 * Die Verwendung dieser Datenklasse erleichtert die Verwaltung und Verarbeitung von Benutzerdaten in der App.
 */