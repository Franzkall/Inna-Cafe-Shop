package com.example.abschlussaufgabe.json

import com.example.abschlussaufgabe.data.model.DrinkItems
import retrofit2.Call
import retrofit2.http.GET

interface MyApi {
    @GET("drinks")
    fun getDrinks(): Call<List<DrinkItems>>
}
