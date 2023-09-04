/**
 * Repository-Klasse zur Interaktion mit der Erfrischungsdatenbank.
 */

package com.example.abschlussaufgabe.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.abschlussaufgabe.data.db.RefreshmentDatabase
import com.example.abschlussaufgabe.data.model.PriceListData

const val TAG = "RefreshmentRepository"

class RefreshmentRepository(private val database: RefreshmentDatabase) {

    // LiveData-Objekt, das eine Liste von Preisdaten aus der Datenbank enthält.
    val refreshmentList: LiveData<List<PriceListData>> = database.refreshmentDao.getAll()

    /**
     * Fügt ein Preisdaten-Objekt in die Datenbank ein.
     *
     * @param listData Das Preisdaten-Objekt, das eingefügt werden soll.
     */
    suspend fun insert(listData: PriceListData) {
        try {
            database.refreshmentDao.insert(listData)
        } catch (e: Exception) {
            Log.d(TAG, "Fehler beim Einfügen in die Datenbank: $e")
        }
    }

    /**
     * Fügt eine Liste von Preisdaten-Objekten in die Datenbank ein.
     *
     * @param refreshment Die Liste von Preisdaten-Objekten, die eingefügt werden sollen.
     */
    suspend fun insertAll(refreshment: List<PriceListData>) {
        database.refreshmentDao.insertAll(refreshment)
    }
}

/**
 * Fachlicher Kommentar:
 *
 * Die `RefreshmentRepository`-Klasse ist verantwortlich für die Interaktion mit der Erfrischungsdatenbank. Sie stellt Methoden zum Einfügen von Preisdaten
 * in die Datenbank zur Verfügung und ermöglicht den Zugriff auf eine LiveData-Liste von Preisdaten aus der Datenbank. Dieses Repository vereinfacht
 * den Zugriff auf die Datenbank und sorgt für eine saubere Trennung der Datenzugriffslogik von der Oberflächenlogik der App.
 */
