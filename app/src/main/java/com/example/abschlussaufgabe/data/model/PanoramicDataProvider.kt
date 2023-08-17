package com.example.abschlussaufgabe.data.model

import com.example.abschlussaufgabe.R

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
