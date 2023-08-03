package com.example.abschlussaufgabe.data.model


class Drink(
    var cover: Int,
    var author: String,
    var title: String,
    var description: String,
    var id: Int = 0
)

var drinkList = mutableListOf<Drink>()

val DRINK_ID_EXTRA = "drinkExtra"




