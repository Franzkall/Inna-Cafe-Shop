package com.example.abschlussaufgabe.data.model

  val DRINK_ID_EXTRA = "drinkExtra"

var drinkList = mutableListOf<Drink>()

class Drink(
    var cover: Int,
    var author: String,
    var title: String,
    var description: String,
    val id: Int? = drinkList.size
)



