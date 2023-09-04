/**
 * Lokale Datenklasse für Preislisten-Daten mit Room-Datenbank.
 */

package com.example.abschlussaufgabe.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// Moneyfragment ( Inspektor- Modus)

@Entity(tableName = "price_table") // Definiert den Tabellennamen für die Room-Datenbank
data class PriceListData(
    @PrimaryKey(autoGenerate = true)    // Gibt an, dass die ID automatisch generiert wird
    var id: Long,             // Eindeutige Identifikationsnummer für jedes Element
    var itemName: String,    // Name des Artikels in der Preisliste
    var price: Double,       // Preis des Artikels in der Preisliste
)

/**
 * Fachlicher Kommentar:
 *
 * Diese Datenklasse, `PriceListData`, wird verwendet, um Informationen über Elemente in einer Preisliste in der App zu speichern.
 * Jedes `PriceListData`-Objekt repräsentiert einen Artikel in der Preisliste und enthält eine eindeutige ID, den Namen des Artikels und den Preis.
 * Diese Informationen werden normalerweise im "Moneyfragment" und "Inspektor-Modus" verwendet, um die Preisliste zu verwalten und anzuzeigen.
 * Die Verwendung dieser Datenklasse ermöglicht die Speicherung und Verwaltung von Preislisteninformationen in der Room-Datenbank.
 */
