package com.example.abschlussaufgabe.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.abschlussaufgabe.local.PriceListData

@Database(entities = [PriceListData::class], version = 1)
abstract class RefreshmentDatabase : RoomDatabase() {

    abstract val refreshmentDao: RefreshmentDao

    companion object {
        @Volatile
        private var INSTANCE: RefreshmentDatabase? = null

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
