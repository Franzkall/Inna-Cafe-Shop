package com.example.abschlussaufgabe.data.model

import com.example.abschlussaufgabe.data.model.DrinkItems

// Moneyfragment
/**
 * Datenklasse, die die Antwort von Google Sheets speichert.
 */
data class GoogleSheetResponce(
    val data: List<DrinkItems>
)
