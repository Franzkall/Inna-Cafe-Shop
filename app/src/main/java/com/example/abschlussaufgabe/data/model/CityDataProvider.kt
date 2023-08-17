package com.example.abschlussaufgabe.data.model

import com.example.abschlussaufgabe.R

/**
 * Klasse, die Städtedaten bereitstellt.
 */
class CityDataProvider {

    private val cities = arrayListOf<City>()

    /**
     * Initialisierung der Städtedaten.
     */
    init {
        cities.add(City("London", R.drawable.lz6, "Ecco ksksksksksks, skdkkskffjf, kfnfjfjfnfjfj, djfnfjffjf, dhfjfnfh"))
        cities.add(City("London", R.drawable.lz7, "Ecco"))
        cities.add(City("Mailand", R.drawable.lz10, "Allora"))
        cities.add(City("Mailand", R.drawable.lz9, "Andiamo"))
    }

    /**
     * Gibt die Liste der Städte zurück.
     */
    fun getCities() = cities
}
