package com.example.abschlussaufgabe.repository

import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Image

object CasaImageRepository {
    val imageList = ArrayList<Image>()

    init {
        val image1 = Image(
            R.drawable.jj5,
            "Inna's-Cafe-Shop",
            text =  "khjkhjhgjhjbjh ijhhu jhbh bjhhg gjhghv  jhffztgfgfftfhgfztfztf jhfhghgf jhvhghgfhgf"
        ).apply { id = 1 }
        imageList.add(image1)
    }
    init {
        val image2 = Image(
           R.drawable.nuovo3,
        "Lavazza Geschmack",
            text = "mnmnmnkjj kjhjhgjhjhg mbjhghghv ggjhg"
        ).apply { id = 2 }
        imageList.add(image2)
    }
}