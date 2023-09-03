package com.example.abschlussaufgabe.data.model

/**
 * Datenklasse, die Informationen über ein Bild und Text speichert.
 */
const val IMAGE_ID_EXTRA = "imageExtra"

data class Image(
    val imageSrc: Int,  // Die Quelle (Resource-ID) des Bildes
    val description: String,
    val text: String,
    var id: Int = 0
)
