package com.example.abschlussaufgabe.data.model

// Moneyfragment
/**
 * Datenklasse, die die Antwort von Google Sheets speichert.
 */
data class GoogleSheetResponce(
    val data: List<DrinkItems>
)
/**
 * Fachlicher Kommentar:
 *
 * Diese Datenklasse, `GoogleSheetResponse`, wird verwendet, um die Antwort von Google Sheets zu speichern, wenn Daten abgerufen werden.
 * Die Antwort enthält normalerweise eine Liste von `DrinkItems`, die Informationen über Getränke und deren Preise enthält.
 * Diese Daten werden normalerweise im "MoneyFragment" verwendet, um die Preisliste von Getränken in der App dynamisch zu aktualisieren.
 * Die Verwendung dieser Datenklasse erleichtert die Verarbeitung der Google Sheets-Antwort und ermöglicht eine einfachere Integration
 * von externen Daten in die App.
 */
