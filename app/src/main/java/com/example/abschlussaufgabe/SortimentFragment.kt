package com.example.abschlussaufgabe

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.abschlussaufgabe.adapter.DrinkAdapter
import com.example.abschlussaufgabe.clicklistener.DrinkClickListener
import com.example.abschlussaufgabe.data.model.DRINK_ID_EXTRA
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.databinding.FragmentSortimentBinding

class SortimentFragment : Fragment(), DrinkClickListener {

    private lateinit var binding: FragmentSortimentBinding
    private val drinkList = ArrayList<Drink>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSortimentBinding.inflate(inflater, container, false)

        loadDrinks()

        binding.rvSpecial.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = DrinkAdapter(drinkList, this@SortimentFragment)
        }

        return binding.root
    }

    override fun onClick(drink: Drink) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(DRINK_ID_EXTRA, drink.id)
        startActivity(intent)
    }

    private fun loadDrinks() {
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

        drinkList.add(drink1)
        drinkList.add(drink2)
        drinkList.add(drink3)
        drinkList.add(drink4)
        drinkList.add(drink5)
        drinkList.add(drink6)
    }

}

