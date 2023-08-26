/**
 * Datenbankklasse für Erfrischungsartikel mit Room-Datenbank.
 */
package com.example.abschlussaufgabe.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.abschlussaufgabe.local.PriceListData

// MoneyFragment (Inspektor-Modus)

@Database(entities = [PriceListData::class], version = 1)
abstract class RefreshmentDatabase : RoomDatabase() {

    /**
     * Gibt das DAO-Objekt für die Interaktion mit der Datenbank zurück.
     */
    abstract val refreshmentDao: RefreshmentDao

    companion object {
        @Volatile
        private var INSTANCE: RefreshmentDatabase? = null

        /**
         * Erstellt eine Instanz der Datenbank oder gibt eine vorhandene Instanz zurück.
         */
        fun getInstance(context: Context): RefreshmentDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RefreshmentDatabase::class.java,
                        "refreshment_database"
                    ).build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
