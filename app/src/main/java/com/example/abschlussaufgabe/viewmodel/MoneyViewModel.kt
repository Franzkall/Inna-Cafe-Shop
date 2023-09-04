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
/** Fachlicher Kommentar:
 * Das MoneyFragmentViewModel ist für die Bereitstellung von Getränken mit Preisen für das MoneyFragment verantwortlich.
 * Es verwendet das ApiRepository, um auf Daten von einem externen API-Dienst (MyApi) zuzugreifen und diese im MoneyFragment anzuzeigen.
 * Das ViewModel initialisiert die Liste von Getränken und lädt sie, sobald es erstellt wird.
 * Es verwendet Kotlin Coroutines und den viewModelScope, um die Nebenläufigkeit zu verwalten und die Getränkedaten abzurufen.
 * Die Methode `exampleMethod` dient nur zu Testzwecken und kann für Debugging-Zwecke verwendet werden.
 */