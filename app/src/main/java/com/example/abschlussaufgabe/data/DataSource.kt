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
            Image(R.drawable.jj5,"Inna's Cafe-Shop"),
            Image(R.drawable.nuovo3,"Lavazza Geschmack"),
            Image(R.drawable.jj7,"Smoothie-Bar"),
            Image(R.drawable.jj8,"Patisserie"),
            Image(R.drawable.jj10,"Crepes-Bar"),
            Image(R.drawable.jj9,"Ambiente"),

        )
    }
}
