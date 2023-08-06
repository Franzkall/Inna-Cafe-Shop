package com.example.abschlussaufgabe.data

import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.data.model.Image
import com.example.abschlussaufgabe.data.model.drinkList

class DataSource {


    fun loadImages(): List<Image> {

        return listOf(
        Image(R.drawable.nuovo),
        Image(R.drawable.nuovo2),
        Image(R.drawable.nuovo3),
        Image(R.drawable.nuovo4),
        Image(R.drawable.nuovo6),
        Image(R.drawable.two),
        Image(R.drawable.lavazza),
        Image(R.drawable.bild2),
        Image(R.drawable.new_logo),
        Image(R.drawable.lavazza)

        )
    }

}
    
