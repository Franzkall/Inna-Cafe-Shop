package com.example.abschlussaufgabe


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.abschlussaufgabe.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)



        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationBar = binding.bottomNavigationView
        setupWithNavController(bottomNavigationBar,navController)
    }
    fun navigateToNextFragment() {

        navController.navigate(R.id.casaFragment)
    }
}

// Notiz: ich pushe zurzeit nicht weil ich parallel ein zweite projekt erstellt habe um funktionen auszuprobieren. Für eventuelle fragen stehe ich zur verfügung.
