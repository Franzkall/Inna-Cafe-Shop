package com.example.abschlussaufgabe.repository

import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Drink


object Repository {
    val drinkList = ArrayList<Drink>()

    init {
        val drink1 = Drink(
            R.drawable.foto1,
            "Enrico",
            "Originale",
            "Das Original aus Italien. Stark und konzentriert für den perfekten Weckruf!"
        ).apply { id = 1 }
        drinkList.add(drink1)

        val drink2 = Drink(
            R.drawable.foto2,
            "luigi",
            "essenza",
            "Frühstück wie in Italien. Sein Geschmack ist einfach perfekt."
        ).apply { id = 2 }
        drinkList.add(drink2)

        val drink3 = Drink(
            R.drawable.foto3,
            "Mario",
            "Buono",
            "Fein und süß, ob im Winter oder im Sommer, Balsam für die Seele."
        ).apply { id = 3 }
        drinkList.add(drink3)

        val drink4 = Drink(
            R.drawable.foto4,
            "Sandro",
            "Gustoso",
            "Modern.. Modern, eine Variation, die besonders beliebt ist."
        ).apply { id = 4 }
        drinkList.add(drink4)

        val drink5 = Drink(
            R.drawable.foto5,
            "Bruce",
            "Delicato",
            "Global auch in unserem Lieblingsgetränk."
        ).apply { id = 5 }
        drinkList.add(drink5)

        val drink6 = Drink(
            R.drawable.foto6,
            "Latte Macchiato",
            "Classico",
            "Feiner Geschmack, langer Genuss."
        ).apply { id = 6 }
        drinkList.add(drink6)
    }
}

