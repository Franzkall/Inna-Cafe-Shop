package com.example.abschlussaufgabe.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "price_table")
data class PriceListData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var itemName: String,
    var price: Double,
)

