package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.BuildConfig
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.adapter.DrinkItemsAdapter
import com.example.abschlussaufgabe.data.model.DrinkItems
import com.example.abschlussaufgabe.databinding.FragmentMoneyBinding
import com.example.abschlussaufgabe.json.MyApi
import com.example.abschlussaufgabe.viewholder.MoneyFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoneyFragment : Fragment() {
    private val apiKey = BuildConfig.API_KEY

    private val BASEURL = "https://script.google.com/macros/s/${apiKey}/exec/"

    private val TAG: String = "DRINK_LIST"

    private lateinit var viewModel: MoneyFragmentViewModel
    private lateinit var adapter: DrinkItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMoneyBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_money, container, false)

        viewModel = ViewModelProvider(this)[MoneyFragmentViewModel::class.java]

        adapter = DrinkItemsAdapter()
        val recyclerView: RecyclerView = binding.recyclerView2
        recyclerView.adapter = adapter

        viewModel.drinksList.observe(viewLifecycleOwner, Observer { drinks ->
            adapter.setDrinkItems(drinks)
        })

        getAllDrinks()

        return binding.root
    }

    private fun getAllDrinks() {
        val api = Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        api.getDrinks().enqueue(object : Callback<List<DrinkItems>> {
            override fun onResponse(call: Call<List<DrinkItems>>, response: Response<List<DrinkItems>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        viewModel.drinksList.value = it
                    }
                }
            }

            override fun onFailure(call: Call<List<DrinkItems>>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }
        })
    }
}
