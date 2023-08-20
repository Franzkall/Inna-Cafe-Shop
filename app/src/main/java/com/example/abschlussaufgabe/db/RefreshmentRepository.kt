package com.example.abschlussaufgabe.db

import android.content.Context
import com.example.abschlussaufgabe.exampledata.ListData
import com.example.abschlussaufgabe.local.PriceListData

class RefreshmentRepository(private val database: RefreshmentDatabase) {

    companion object {
        private var repository: RefreshmentRepository? = null

        fun getInstance(context: Context): RefreshmentRepository =
            repository ?: buildRepo(
                RefreshmentDatabase.getInstance(context.applicationContext)
            ).also {
                repository = it
            }

        private fun buildRepo(refreshmentDatabase: RefreshmentDatabase): RefreshmentRepository =
            RefreshmentRepository(refreshmentDatabase)
    }

    fun prepopulateDB() {
        try {
            if (database.refreshmentDao.getCount() == 0) {
                database.refreshmentDao.insertItem(ListData.refreshment1)
                database.refreshmentDao.insertItem(ListData.refreshment2)
                database.refreshmentDao.insertItem(ListData.refreshment3)
                database.refreshmentDao.insertItem(ListData.refreshment4)
                database.refreshmentDao.insertItem(ListData.refreshment5)
                database.refreshmentDao.insertItem(ListData.refreshment6)
                database.refreshmentDao.insertItem(ListData.refreshment7)
                database.refreshmentDao.insertItem(ListData.refreshment8)
                database.refreshmentDao.insertItem(ListData.refreshment9)
                database.refreshmentDao.insertItem(ListData.refreshment10)
                database.refreshmentDao.insertItem(ListData.refreshment11)
                database.refreshmentDao.insertItem(ListData.refreshment12)
                database.refreshmentDao.insertItem(ListData.refreshment13)
                database.refreshmentDao.insertItem(ListData.refreshment14)
                database.refreshmentDao.insertItem(ListData.refreshment15)
                database.refreshmentDao.insertItem(ListData.refreshment16)
                database.refreshmentDao.insertItem(ListData.refreshment17)
                database.refreshmentDao.insertItem(ListData.refreshment18)
                database.refreshmentDao.insertItem(ListData.refreshment19)
                database.refreshmentDao.insertItem(ListData.refreshment20)

            }
        } catch (e: Exception) { }
    }
    fun updateItem(itemData: PriceListData) {
        database.refreshmentDao.updateItem(itemData)
    }

    fun deleteItem(itemData: PriceListData) {
        database.refreshmentDao.deleteItem(itemData)
    }
}
