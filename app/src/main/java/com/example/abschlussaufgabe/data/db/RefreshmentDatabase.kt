/**
 * Datenbankklasse für Erfrischungsartikel mit Room-Datenbank.
 */
package com.example.abschlussaufgabe.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.abschlussaufgabe.data.model.PriceListData

// MoneyFragment (Inspektor-Modus)

@Database(entities = [PriceListData::class], version = 1)
abstract class RefreshmentDatabase : RoomDatabase() {

    abstract val refreshmentDao: RefreshmentDao
}

private lateinit var INSTANCE: RefreshmentDatabase

/**
 * Methode zur Erstellung oder Abruf einer Instanz der RefreshmentDatabase.
 *
 * @param context Der Anwendungskontext.
 * @return Eine Instanz der RefreshmentDatabase.
 */
fun getDataBase(context: Context): RefreshmentDatabase {
    synchronized(RefreshmentDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                RefreshmentDatabase::class.java,
                "refreshment_database"
            )
                .allowMainThreadQueries().build()
        }
    }
    return INSTANCE
}
