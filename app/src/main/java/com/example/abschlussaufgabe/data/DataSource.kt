package com.example.abschlussaufgabe.data

import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.data.model.Image
import com.example.abschlussaufgabe.data.model.drinkList

class DataSource {


    fun loadImages(): List<Image> {

        return listOf(
        Image(R.drawable.tu),
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
          Drink(R.drawable.foto9, "1","1","1",1),
          Drink(R.drawable.foto1,"2","2","2",2),
          Drink(R.drawable.foto2,"3","3","3",3),
          Drink(R.drawable.foto3,"4","4","4",4),
          Drink(R.drawable.foto4,"5","5","5",5),
          Drink(R.drawable.foto5,"6","6","6",6),
          Drink(R.drawable.foto6,"7","7","7",7),
           Drink(R.drawable.foto7,"8","8","8",8),
           Drink(R.drawable.foto8,"9","9","9",9)

        )
    }
}
    
