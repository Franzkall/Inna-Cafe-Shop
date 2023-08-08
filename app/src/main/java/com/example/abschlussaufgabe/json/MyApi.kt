package com.example.abschlussaufgabe.json

import com.example.abschlussaufgabe.data.model.DrinkItems
import retrofit2.Call
import retrofit2.http.GET

// Diese Schnittstelle definiert eine API zum Abrufen von Getränkeinformationen.

interface MyApi {

    // Diese Methode verwendet die HTTP GET-Methode, um eine Liste von Getränken abzurufen.
    @GET("drinks")
    fun getDrinks(): Call<List<DrinkItems>>
}
