package com.example.abschlussaufgabe.repository

import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Image

object CasaImageRepository {
    val imageList = ArrayList<Image>()

    init {
        val image1 = Image(
            R.drawable.jj5,
            "Inna's-Cafe-Shop"
        ).apply { id = 1 }
        imageList.add(image1)
    }
    init {
        val image2 = Image(
           R.drawable.nuovo3,
        "Lavazza Geschmeck"
        ).apply { id = 2 }
        imageList.add(image2)
    }
}