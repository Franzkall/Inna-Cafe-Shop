package com.example.abschlussaufgabe.repository

import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Drink
// FragmentSortiment

/**
 * Singleton-Objekt, das als Repository für Getränkeinformationen dient.
 */
object Repository {
    val drinkList = ArrayList<Drink>() // Eine liste von drink-objekten, die in repository gespeichert wird.

    init {
        // Hier werden verschiedene Drink Objekte erstellt und zur drinklist hinzugefügt
        val drink1 = Drink(
            R.drawable.es1,
            "2,30 €",
            "Espresso",
            "Espresso ist eine konzentrierte Kaffeezubereitung, bei der heißes Wasser mit hohem Druck durch fein gemahlenes Kaffeemehl gepresst wird. Diese Methode extrahierte intensive Aromen und Öle in etwa 25-30 Sekunden, und das Ergebnis ist ein reichhaltiger und kräftiger Kaffee mit dicker Crema. "
        ).apply { id = 1 }
        drinkList.add(drink1)

        val drink2 = Drink(
            R.drawable.es2,
            "3,50 €",
            "Cappuccino",
            "Cappuccino ist eine ausgewogene Kombination aus Espresso, heißer Milch und Milchschaum. Ursprünglich in Italien entstanden, ist der Cappuccino weltweit bekannt. Die Zubereitung beginnt mit einem kräftigen Espresso, dem heiße Milch hinzugefügt wird. Anschließend wird Milchschaum aufgegossen, wodurch sich eine charakteristische Dreischicht-Struktur bildet."
        ).apply { id = 2 }
        drinkList.add(drink2)

        val drink3 = Drink(
            R.drawable.foto4,
            "3,50 €",
            "Latte Macchiato",
            "Ein delikater Kaffee, bestehend aus schichtweise gegossener Milch und Espresso. Die sanfte Süße der Milch kombiniert mit der kräftigen Intensität des Espresso sorgt für ein harmonisches Geschmackserlebnis. Ob im Winter zum Aufwärmen oder im Sommer als erfrischender Genuss – der Latte Macchiato ist eine Wohltat für die Sinne."
        ).apply { id = 3 }
        drinkList.add(drink3)

        val drink4 = Drink(
            R.drawable.foto5,
            "3,20 €",
            "Cioccolata Italiana",
            "Verwöhnen Sie sich mit einer italienischen Köstlichkeit – reichhaltige Schokolade in flüssiger Form. Ein sündhaft leckeres Getränk, das puren Genuss verspricht und Ihre Sinne umhüllt."
        ).apply { id = 4 }
        drinkList.add(drink4)

        val drink5 = Drink(
            R.drawable.jj14,
            "4,20 €",
            "Schokolino",
            "Ein verlockender Frappuccino mit dem unwiderstehlichen Geschmack von Kinder Bueno. Genießen Sie die perfekte Kombination aus Schokolade und Kaffee in einem erfrischenden Getränk."
        ).apply { id = 5 }
        drinkList.add(drink5)


        val drink6 = Drink(
            R.drawable.jj15,
            "4,50 €",
            "Milchshake Joghurette",
            "Genießen Sie die perfekte Verbindung von cremigem Joghurt und Schokolade in unserem unwiderstehlichen Milchshake. Ein Genuss, der lange auf der Zunge bleibt."
        ).apply { id = 6 }
        drinkList.add(drink6)

        val drink7 = Drink(
            R.drawable.foto5,
            "Bruce",
            "Delicato",
            "Global auch in unserem Lieblingsgetränk."
        ).apply { id = 7 }
        drinkList.add(drink7)

        val drink8 = Drink(
            R.drawable.foto6,
            "Latte Macchiato",
            "Classico",
            "Feiner Geschmack, langer Genuss."
        ).apply { id = 8 }
        drinkList.add(drink8)

        val drink9 = Drink(
            R.drawable.foto6,
            "Latte Macchiato",
            "Classico",
            "Feiner Geschmack, langer Genuss."
        ).apply { id = 9 }
        drinkList.add(drink9)

        val drink10 = Drink(
            R.drawable.foto5,
            "Bruce",
            "Delicato",
            "Global auch in unserem Lieblingsgetränk."
        ).apply { id = 10 }
        drinkList.add(drink10)

        val drink11 = Drink(
            R.drawable.foto6,
            "Latte Macchiato",
            "Classico",
            "Feiner Geschmack, langer Genuss."
        ).apply { id = 11 }
        drinkList.add(drink11)

        val drink12 = Drink(
            R.drawable.foto5,
            "Bruce",
            "Delicato",
            "Global auch in unserem Lieblingsgetränk."
        ).apply { id = 12 }
        drinkList.add(drink12)

        val drink13 = Drink(
            R.drawable.foto6,
            "Latte Macchiato",
            "Classico",
            "Feiner Geschmack, langer Genuss."
        ).apply { id = 13 }
        drinkList.add(drink13)

        val drink14 = Drink(
            R.drawable.foto6,
            "Latte Macchiato",
            "Classico",
            "Feiner Geschmack, langer Genuss."
        ).apply { id = 14 }
        drinkList.add(drink14)

        val drink15 = Drink(
            R.drawable.foto5,
            "Bruce",
            "Delicato",
            "Global auch in unserem Lieblingsgetränk."
        ).apply { id = 15 }
        drinkList.add(drink15)

        val drink16 = Drink(
            R.drawable.foto6,
            "Latte Macchiato",
            "Classico",
            "Feiner Geschmack, langer Genuss."
        ).apply { id = 16 }
        drinkList.add(drink16)
    }
}

