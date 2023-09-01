
package com.example.abschlussaufgabe.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.abschlussaufgabe.data.model.PriceListData

/**
 * Data Access Object (DAO) zur Interaktion mit der Datenbank für Erfrischungsartikel.
 */

// MoneyFragment (Alternative Preisliste-Speicherung über Room, Inspektor-Modus)

@Dao
interface  RefreshmentDao {

    /**
     * Fügt einen Erfrischungsartikel zur Datenbank hinzu oder ersetzt ihn, wenn er bereits existiert.
     * @param refreshmentDatabase Der hinzuzufügende oder zu ersetzende Erfrischungsartikel.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
      fun insert(refreshmentDatabase: PriceListData)

    /**
     * Fügt eine Liste von Erfrischungsartikeln zur Datenbank hinzu oder ersetzt sie, wenn sie bereits existieren.
     * @param priceListData Die Liste der hinzuzufügenden oder zu ersetzenden Erfrischungsartikel.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(priceListData: List<PriceListData>)

    /**
     * Aktualisiert einen Erfrischungsartikel in der Datenbank.
     * @param refreshmentDatabase Der zu aktualisierende Erfrischungsartikel.
     */
    @Update
      fun update(refreshmentDatabase: PriceListData)

    /**
     * Ruft alle Erfrischungsartikel aus der Datenbank ab und liefert sie als LiveData.
     * @return LiveData-Objekt, das eine Liste von Erfrischungsartikeln enthält.
     */
    @Query("SELECT * FROM price_table")
    fun getAll(): LiveData<List<PriceListData>>

    /**
     * Ruft einen Erfrischungsartikel aus der Datenbank anhand seiner ID ab und liefert ihn als LiveData.
     * @param key Die ID des abzurufenden Erfrischungsartikels.
     * @return LiveData-Objekt, das den abgerufenen Erfrischungsartikel enthält.
     */
    @Query("SELECT * from price_table WHERE id = :key")
    fun getById(key: Int): LiveData<PriceListData>

}