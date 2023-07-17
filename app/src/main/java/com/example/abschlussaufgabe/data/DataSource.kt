package com.example.abschlussaufgabe.data

import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Image

class DataSource {

    fun loadImages(): List<Image> {

        return listOf(
        Image(R.drawable.bild1),
        Image(R.drawable.inside),
        Image(R.drawable.bild4),
        Image(R.drawable.caffe),
        Image(R.drawable.new_logo),
        Image(R.drawable.lavazza)

        )
    }
}