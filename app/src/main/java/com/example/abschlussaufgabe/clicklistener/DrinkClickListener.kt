package com.example.abschlussaufgabe.clicklistener

import com.example.abschlussaufgabe.data.model.Drink
// Hot_and_Cold
// Schnittstelle für den DrinkClickListener
interface DrinkClickListener {

    // Methode, die aufgerufen wird, wenn auf einen Drink geklickt wird
    fun onClick(drink: Drink)
}
