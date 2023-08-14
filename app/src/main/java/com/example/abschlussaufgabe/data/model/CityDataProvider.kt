package com.example.abschlussaufgabe.data.model

import com.example.abschlussaufgabe.R

class CityDataProvider {

    private val cities = arrayListOf<City>()

    init {
        cities.add(City("London", R.drawable.lz6,"Ecco ksksksksksks, skdkkskffjf, kfnfjfjfnfjfj, djfnfjffjf,dhfjfnfh"))
        cities.add(City("London", R.drawable.lz7,"Ecco"))
        cities.add(City("Mailand",R.drawable.lz10,"Allora"))
        cities.add(City("Mailand",R.drawable.lz9,"Andiamo"))
    }
    fun getCities() = cities
}