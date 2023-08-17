package com.example.abschlussaufgabe.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.abschlussaufgabe.data.model.City
import com.example.abschlussaufgabe.data.model.CityDataProvider

/**
 * ViewModel für die Anzeige von ständig wechselnden Städteinformationen.
 */
class CityViewModel : ViewModel() {

    private val cityData = MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()
    private var currentIndex = 0
    private val delay = 4000L // Verzögerung in Millisekunden zwischen den Stadtaktualisierungen

    /**
     * Initialisierung des ViewModels, startet den Zyklus der Stadtaktualisierungen.
     */
    init {
        loop()
    }

    /**
     * Gibt die LiveData-Instanz für die Stadtinformationen zurück.
     */
    fun getCityData(): LiveData<City> = cityData

    /**
     * Startet den Zyklus der Stadtaktualisierungen mit einer Verzögerung.
     */
    private fun loop() {
        Handler(Looper.getMainLooper()).postDelayed({ updateCity() }, delay)
    }

    /**
     * Aktualisiert die angezeigte Stadt und startet den Zyklus erneut.
     */
    private fun updateCity() {
        currentIndex++
        currentIndex %= cities.size

        cityData.value = cities[currentIndex]

        loop()
    }
}
