package com.example.abschlussaufgabe.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entitätsklasse für die Preisdatenbank-Tabelle
@Entity(tableName = "price_table")
data class Price(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,       // Eindeutige ID des Preises (wird automatisch generiert)
    var name: String,     // Name des Produkts oder des Preises
    var price: Double     // Der Preiswert als Double
)
