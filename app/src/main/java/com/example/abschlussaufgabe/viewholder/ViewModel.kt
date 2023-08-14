package com.example.abschlussaufgabe.viewholder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abschlussaufgabe.data.model.DrinkItems
import com.example.abschlussaufgabe.json.MyApi
import com.example.abschlussaufgabe.repository.ApiRepository
import kotlinx.coroutines.launch

// Dieses ViewModel dient dazu, eine Liste von Getränken mit Preisen für das MoneyFragment bereitzustellen.

class MoneyFragmentViewModel : ViewModel() {
    val drinksList = MutableLiveData<List<DrinkItems>>()
    private val repository = ApiRepository(MyApi)

    val drinks = repository.drinks

    init {
       loadDrinks()
    }

    private fun loadDrinks() {
        viewModelScope.launch {
            repository.getDrinks()
        }
    }


}
