package com.example.abschlussaufgabe.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.abschlussaufgabe.data.model.Panoramic
import com.example.abschlussaufgabe.data.PanoramicDataProvider
//ViewFragment
/**
 * ViewModel für die Anzeige von ständig wechselnden Bilderinformationen.
 */
class PanoramicViewModel : ViewModel() {

    private val pictureData = MutableLiveData<Panoramic>()
    private val pictures = PanoramicDataProvider().getPictures()
    private var currentIndex = 0
    private val delay = 4000L // Verzögerung in Millisekunden zwischen den Stadtaktualisierungen

    /**
     * Initialisierung des ViewModels, startet den Zyklus der Bildaktualisierungen.
     */
    init {
        loop()
    }

    /**
     * Gibt die LiveData-Instanz für die Bildtinformationen zurück.
     */
    fun getPictureData(): LiveData<Panoramic> = pictureData

    /**
     * Startet den Zyklus der Bildaktualisierungen mit einer Verzögerung.
     */
    private fun loop() {
        Handler(Looper.getMainLooper()).postDelayed({ updatePicture() }, delay)
    }

    /**
     * Aktualisiert die angezeigte Bilder und startet den Zyklus erneut.
     */
    private fun updatePicture() {
        currentIndex++
        currentIndex %= pictures.size

        pictureData.value = pictures[currentIndex]

        loop()
    }
}
