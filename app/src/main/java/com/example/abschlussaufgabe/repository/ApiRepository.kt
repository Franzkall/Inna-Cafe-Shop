package com.example.abschlussaufgabe.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abschlussaufgabe.BuildConfig
import com.example.abschlussaufgabe.data.model.DrinkItems
import com.example.abschlussaufgabe.json.MyApi

class ApiRepository(private val api: MyApi) {
    private val _drinks = MutableLiveData<List<DrinkItems>>()
    private val apiKey = BuildConfig.API_KEY

    val drinks: LiveData<List<DrinkItems>>
        get() = _drinks

    suspend fun getDrinks() {
        try {
            _drinks.value = api.retroFitService.getDrinks(apiKey).data
        }catch (e: Exception) {
            Log.e("ApiRepository", "Fehler beim laden von daten: $e")
        }

    }

}


