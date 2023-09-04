package com.example.abschlussaufgabe.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abschlussaufgabe.data.api.MyApi
import com.example.abschlussaufgabe.repository.ApiRepository
import kotlinx.coroutines.launch
//MoneyFragment
/**
 * Dieses ViewModel dient dazu, eine Liste von Getränken mit Preisen für das MoneyFragment bereitzustellen.
 */
class MoneyFragmentViewModel : ViewModel() {
    private val repository = ApiRepository(MyApi)

    val drinks = repository.drinks

    /**
     * Initialisiert das ViewModel und lädt die Getränke.
     */
    init {
        loadDrinks()
    }
   fun stephan() {
       Log.e("Hallo", "Hello")
    }
    /**
     * Lädt die Getränke mithilfe des Repositorys und Coroutine-Scope.
     */
    private fun loadDrinks() {
        viewModelScope.launch {
            repository.getDrinks()
        }
    }
}
