package com.example.abschlussaufgabe.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "price_table")

data class Price(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var name: String,
    var price: Double
)
