package com.example.abschlussaufgabe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.abschlussaufgabe.data.model.DRINK_ID_EXTRA
import com.example.abschlussaufgabe.data.model.Drink
import com.example.abschlussaufgabe.data.model.drinkList
import com.example.abschlussaufgabe.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drinkId = intent.getIntExtra(DRINK_ID_EXTRA,-1)
        val drink = drinkFromId(drinkId)
        if(drink != null)
        {
            binding.cover.setImageResource(drink.cover)
            binding.title.text = drink.title
            binding.description.text = drink.description
            binding.author.text = drink.author
        }
    }
    private fun drinkFromId(drinkId: Int): Drink?
    {
        for (drink in drinkList)
        {
            if (drink.id == drinkId)
                return drink
        }
        return null
    }
}