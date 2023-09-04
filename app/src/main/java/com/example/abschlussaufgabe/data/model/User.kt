package com.example.abschlussaufgabe.data.model

// RegisterFragment

/**
 * Datenklasse für Benutzerinformationen.
 */
data class User(
    val userID: String, // Eindeutige Benutzer-ID
    val name: String,   // Name des Benutzers
    val score: Int      // Punktzahl oder Bewertung des Benutzers
)

/**
 * Fachlicher Kommentar:
 *
 * Diese Datenklasse, `User`, wird verwendet, um Benutzerinformationen in der App zu speichern.
 * Jedes `User`-Objekt enthält die eindeutige Benutzer-ID, den Namen des Benutzers und seine Punktzahl oder Bewertung.
 * Diese Informationen werden normalerweise im "RegisterFragment" verwendet, um Benutzerdaten zu erfassen und zu verarbeiten.
 * Die Verwendung dieser Datenklasse erleichtert die Verwaltung und Verarbeitung von Benutzerdaten in der App.
 */
