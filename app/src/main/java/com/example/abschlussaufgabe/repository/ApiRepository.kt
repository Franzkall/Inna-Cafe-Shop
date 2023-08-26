package com.example.abschlussaufgabe.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abschlussaufgabe.BuildConfig
import com.example.abschlussaufgabe.data.model.DrinkItems
import com.example.abschlussaufgabe.json.MyApi

// MoneyFragment

/**
 * Repository-Klasse für die Kommunikation mit der API.
 */
class ApiRepository(private val api: MyApi) {
    private val _drinks = MutableLiveData<List<DrinkItems>>()
    private val apiKey = BuildConfig.API_KEY

    /**
     * Eine LiveData-Instanz für die Getränkeinformationen.
     */
    val drinks: LiveData<List<DrinkItems>>
        get() = _drinks

    /**
     * Ruft Getränkeinformationen von der API ab.
     */
    suspend fun getDrinks() {
        try {
            _drinks.value = api.retroFitService.getDrinks(apiKey).data
        } catch (e: Exception) {
            Log.e("ApiRepository", "Fehler beim Laden von Daten: $e")
        }
    }
}
