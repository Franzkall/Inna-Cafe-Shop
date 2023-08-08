package com.example.abschlussaufgabe.json

import com.example.abschlussaufgabe.data.model.GoogleSheetResponce
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// Diese Schnittstelle definiert eine API zum Abrufen von Getränkeinformationen.

const val  BASE_URL = "https://script.googleusercontent.com/macros/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MyApiService {

    // Diese Methode verwendet die HTTP GET-Methode, um eine Liste von Getränken abzurufen.
    @GET("echo?user_content_key=4S3cQ1QOR3lo2ODJNlMTNHVwk9hkd5oCqiUILRXpYvYbrEtypGNpVuGzSOPaSwck64kXqtpo98J0WRRmefCDzS3_AMx0qcnvm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnDWBRZUf39akLhqqqc71WsbIpVxFHpz6yHydJnKTQpB5p-vRjTY41fhHkCCfLxNbfthV7eEZPXvaEQqiaRbmCKFDWh8xqhi_Ig&lib=MMaZo9b1iaA3ZFg8Nd9XJ6C-41kuCiUbs")
   suspend fun getDrinks(): GoogleSheetResponce
}

object MyApi {
    val retroFitService: MyApiService by lazy { retrofit.create(MyApiService::class.java) }
}
