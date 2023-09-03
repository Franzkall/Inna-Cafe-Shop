package com.example.abschlussaufgabe.repository

import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Image

object CasaImageRepository {
    val imageList = ArrayList<Image>()

    init {
        val image1 = Image(
            R.drawable.pk2,
            "Inna's-Cafe-Shop",
            text =  "LavAzza Kaffee-Shop-Moers - Homberger Str.5 - Tel: 02841 91660910"
        ).apply { id = 1 }
        imageList.add(image1)
    }
    init {
        val image2 = Image(
            R.drawable.pk5,
        "Punkte Sammeln",
            text = "Kaufe und sammle Punkte ganz einfach, indem du nach jeden Kauf den QR-Code scannst.Diese Punkte kannst du dann gegen Getränke oder Speisen eintauschen. Erstelle jetzt direkt in unserer App ein Konto. Viel Spaß beim Sammeln!"
        ).apply { id = 2 }
        imageList.add(image2)
    }
    init {
        val image3 = Image(
            R.drawable.pk1,
            "Traditionelle Patisserie",
            "Genießen Sie zwischendurch unsere hausgemachten Torten und Waffeln. Erleben Sie die traditionelle italienische Patisserie begleitet mit dem unverwechselbaren Aroma von Lavazza Kaffee."
        ).apply { id = 3 }
        imageList.add(image3)
   }
}