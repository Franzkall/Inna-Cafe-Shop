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
    fun benjamin() {
        Log.e("Hallo", "Hello")
    }

    private fun insertExampleData() {
        viewModelScope.launch {
           val exampleData = ListData
            try {
                repository.insert(exampleData.refreshment1)
                repository.insert(exampleData.refreshment2)
                repository.insert(exampleData.refreshment3)
                repository.insert(exampleData.refreshment4)
                repository.insert(exampleData.refreshment5)
                repository.insert(exampleData.refreshment6)
                repository.insert(exampleData.refreshment7)
                repository.insert(exampleData.refreshment8)
                repository.insert(exampleData.refreshment9)
                repository.insert(exampleData.refreshment10)
                repository.insert(exampleData.refreshment11)
                repository.insert(exampleData.refreshment12)
                repository.insert(exampleData.refreshment13)
                repository.insert(exampleData.refreshment14)
                repository.insert(exampleData.refreshment15)
                repository.insert(exampleData.refreshment16)
                repository.insert(exampleData.refreshment17)
                repository.insert(exampleData.refreshment18)
                repository.insert(exampleData.refreshment19)
                repository.insert(exampleData.refreshment20)


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