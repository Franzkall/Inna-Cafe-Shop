package com.example.abschlussaufgabe.data

import android.graphics.Picture
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.data.model.Image

class DataSource {


    fun loadImages(): List<Image> {

        return listOf(
        Image(R.drawable.one),
        Image(R.drawable.two),
        Image(R.drawable.inside),
        Image(R.drawable.bild2),
        Image(R.drawable.new_logo),
        Image(R.drawable.lavazza)

        )
    }

    fun loadDrinks(): List<Drink> {

        return listOf(
            Drink(R.drawable.lavazza),
            Drink(R.drawable.exp),
            Drink(R.drawable.lm)
        )
    }
    
}