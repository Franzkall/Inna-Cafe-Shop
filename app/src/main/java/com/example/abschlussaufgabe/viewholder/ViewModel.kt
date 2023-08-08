package com.example.abschlussaufgabe.viewholder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.abschlussaufgabe.data.model.DrinkItems

// Dieses ViewModel dient dazu, eine Liste von Getränken mit Preisen für das MoneyFragment bereitzustellen.

class MoneyFragmentViewModel : ViewModel() {
    val drinksList = MutableLiveData<List<DrinkItems>>() // Eine MutableLiveData-Instanz für die Getränkeliste.
}
