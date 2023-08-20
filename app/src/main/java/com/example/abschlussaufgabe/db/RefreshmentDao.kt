package com.example.abschlussaufgabe.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import com.example.abschlussaufgabe.local.PriceListData

@Dao
interface RefreshmentDao {
    @Insert
    fun insertItem(itemData: PriceListData)

    @Update
    fun updateItem(itemData: PriceListData)

    @Delete
    fun deleteItem(itemData: PriceListData)

    @Query("SELECT COUNT(*) FROM price_table")
    fun getCount(): Int

}
