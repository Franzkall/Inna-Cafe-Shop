package com.example.abschlussaufgabe.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.abschlussaufgabe.data.db.getDataBase
import com.example.abschlussaufgabe.data.exampledata.ListData
import com.example.abschlussaufgabe.data.model.PriceListData
import com.example.abschlussaufgabe.repository.RefreshmentRepository
import kotlinx.coroutines.launch

class RefreshmentViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDataBase(application)
    private val repository = RefreshmentRepository(database)

    val priceListData = repository.refreshmentList

    init {
        insertExampleData()
    }

    private fun insertExampleData() {
        viewModelScope.launch {
            val exampleData = ListData
            try {
                repository.insert(exampleData.refreshment1)
                repository.insert(exampleData.refreshment2)
                // andere refreshment......
            } catch (e: Exception) {
                Log.d(TAG, "Failed to insert example data into Database: $e")
            }
        }
    }

    fun insertRefreshment(refreshment: PriceListData) {
        viewModelScope.launch {
            repository.insert(refreshment)
        }

    }
    fun insertAllRefreshment(refreshment: List<PriceListData>) {
        viewModelScope.launch {
            repository.insertAll(refreshment)
        }
    }
}