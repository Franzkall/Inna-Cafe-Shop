package com.example.abschlussaufgabe.data

import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Image
//CasaFragment
/**
 * Datenquelle für Bilder.
 */
class DataSource {

    /**
     * Lädt eine Liste von Bildern und Texte
     */
    fun loadImages(): List<Image> {
        return listOf(
            Image(R.drawable.codice,"Trest1"),
            Image(R.drawable.nuovo2,"test2"),
            Image(R.drawable.nuovo3,"test3"),
            Image(R.drawable.shakes,"test4"),
            Image(R.drawable.nuovo6,"test"),
            Image(R.drawable.gg1,"test6"),
            Image(R.drawable.gg2,"arci"),
            Image(R.drawable.two,"pelago"),
            Image(R.drawable.bild2,"wolke"),
            Image(R.drawable.new_logo,"mare"),
            Image(R.drawable.lavazza,"terra")
        )
    }
}
