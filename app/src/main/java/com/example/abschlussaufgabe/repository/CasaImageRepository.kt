package com.example.abschlussaufgabe.repository

import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Image

/**
 * Singleton-Objekt, das als Repository für Bilder und Texte dient, die im "CasaFragment" angezeigt werden.
 */
object CasaImageRepository {
    val imageList = ArrayList<Image>()

    init {
        // Bild und Text 1: Inna's-Cafe-Shop
        val image1 = Image(
            R.drawable.pk2,
            "Inna's-Cafe-Shop",
            text =  "LavAzza Kaffee-Shop-Moers - Homberger Str.5 - Tel: 02841 91660910 - Email Adresse _moers@hotmail.com"
        ).apply { id = 1 }
        imageList.add(image1)
    }

    init {
        // Bild und Text 2: Punkte Sammeln
        val image2 = Image(
            R.drawable.pk5,
            "Punkte Sammeln",
            text = "Kaufe und sammle Punkte ganz einfach, indem du nach jedem Kauf den QR-Code scannst. Diese Punkte kannst du dann gegen Getränke oder Speisen eintauschen. Erstelle jetzt direkt in unserer App ein Konto. Viel Spaß beim Sammeln!"
        ).apply { id = 2 }
        imageList.add(image2)
    }

    init {
        // Bild und Text 3: Traditionelle Patisserie
        val image3 = Image(
            R.drawable.pk1,
            "Traditionelle Patisserie",
            "Genießen Sie zwischendurch unsere hausgemachten Torten und Waffeln. Erleben Sie die traditionelle italienische Patisserie begleitet mit dem unverwechselbaren Aroma von Lavazza Kaffee."
        ).apply { id = 3 }
        imageList.add(image3)
    }
}

/**
 * Fachlicher Kommentar:
 *
 * Das `CasaImageRepository` ist ein Singleton-Objekt, das als Repository für Bilder und Texte dient, die im "CasaFragment" angezeigt werden.
 * Es enthält eine Liste von `Image`-Objekten, wobei jedes Objekt ein Bild und einen dazugehörigen Text enthält. Diese Informationen können im
 * "CasaFragment" abgerufen und angezeigt werden. Das Repository ermöglicht eine zentrale Verwaltung der Inhalte, die im "CasaFragment"
 * angezeigt werden, und erleichtert deren Zugriff und Aktualisierung in der App.
 */
