package com.example.abschlussaufgabe.viewholder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.abschlussaufgabe.data.model.DrinkItems

class MoneyFragmentViewModel : ViewModel() {
    val drinksList = MutableLiveData<List<DrinkItems>>()
}
