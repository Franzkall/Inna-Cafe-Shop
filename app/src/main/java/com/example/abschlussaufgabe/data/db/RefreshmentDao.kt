/**
 * Data Access Object (DAO) zur Interaktion mit der Datenbank für Erfrischungsartikel.
 */
package com.example.abschlussaufgabe.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import com.example.abschlussaufgabe.data.model.PriceListData

// MoneyFragment (Alternative Preisliste-Speicherung über Room, Inspektor-Modus)

@Dao
interface RefreshmentDao {
    /**
     * Fügt ein Artikel-Datenelement in die Datenbank ein.
     */
    @Insert
    fun insertItem(itemData: PriceListData)

    /**
     * Aktualisiert ein Artikel-Datenelement in der Datenbank.
     */
    @Update
    fun updateItem(itemData: PriceListData)

    /**
     * Löscht ein Artikel-Datenelement aus der Datenbank.
     */
    @Delete
    fun deleteItem(itemData: PriceListData)

    /**
     * Ruft die Anzahl der Datenelemente in der Preis-Tabelle ab.
     */
    @Query("SELECT COUNT(*) FROM price_table")
    fun getCount(): Int
}
