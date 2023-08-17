package com.example.abschlussaufgabe.data

import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Image

/**
 * Datenquelle für Bilder.
 */
class DataSource {

    /**
     * Lädt eine Liste von Bildern.
     */
    fun loadImages(): List<Image> {
        return listOf(
            Image(R.drawable.codice),
            Image(R.drawable.nuovo2),
            Image(R.drawable.nuovo3),
            Image(R.drawable.shakes),
            Image(R.drawable.nuovo6),
            Image(R.drawable.gg1),
            Image(R.drawable.gg2),
            Image(R.drawable.two),
            Image(R.drawable.bild2),
            Image(R.drawable.new_logo),
            Image(R.drawable.lavazza)
        )
    }
}
