package com.example.abschlussaufgabe.data.api

import com.example.abschlussaufgabe.data.model.GoogleSheetResponce
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// MoneyFragment

/**
 * Diese Schnittstelle definiert eine API zum Abrufen von Getränkeinformationen.
 */

// Basis-URL für die API
const val BASE_URL = "https://script.googleusercontent.com/macros/"

// Erstellt einen Moshi-Adapter mit KotlinJsonAdapterFactory
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Erstellt einen Retrofit-Client mit MoshiConverterFactory
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * Schnittstellenbeschreibung für die API.
 */
interface MyApiService {

    /**
     * Diese Methode verwendet die HTTP GET-Methode, um eine Liste von Getränken abzurufen.
     */
    @GET("echo")
    suspend fun getDrinks(
        @Query("user_content_key") apiKey: String,
        @Query("lib") lib: String = "MMaZo9b1iaA3ZFg8Nd9XJ6C-41kuCiUbs"
    ): GoogleSheetResponce
}

/**
 * Ein Singleton-Objekt, um den Retrofit-Service bereitzustellen.
 */
object MyApi {
    val retroFitService: MyApiService by lazy { retrofit.create(MyApiService::class.java) }
}
