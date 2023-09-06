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
        picture.add(Panoramic("Smoothie Bar", R.drawable.g1, "Smoothie-Bar: Erfrieschende und gesunde Smoothies frisch zubereitet!"))
        picture.add(Panoramic("Croissant und Cappuccino", R.drawable.g5, "Starten Sie ihren Tag wie in Italien mit ein leckeren Croissant und einem Cappuccino"))
        picture.add(Panoramic("Colazione", R.drawable.g3, "Probieren Sie unser breites Angebot zum Frühstuck"))
        picture.add(Panoramic("Torten", R.drawable.gs6, "Ausgezeichnete Torten und Patisserie, auch zum Mitnehmen!"))
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