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

