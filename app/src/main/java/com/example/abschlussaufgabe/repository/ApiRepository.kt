package com.example.abschlussaufgabe.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abschlussaufgabe.data.model.DrinkItems
import com.example.abschlussaufgabe.json.MyApi

class ApiRepository(private val api: MyApi) {
    private val _drinks = MutableLiveData<List<DrinkItems>>()


    val drinks: LiveData<List<DrinkItems>>
        get() = _drinks

    suspend fun getDrinks() {
        try {
            _drinks.value = api.retroFitService.getDrinks().data
        }catch (e: Exception) {
            Log.e("ApiRepository", "Fehler beim laden von daten: $e")
        }

    }

}


