package com.example.abschlussaufgabe.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.databinding.ActivityMainBinding

// Die Hauptaktivität der Anwendung, die die Navigation und das Layout verwaltet.

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Das Layout der Aktivität wird durch Data Binding gesetzt.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Der NavHostFragment und der zugehörige NavController werden initialisiert.
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        // Die untere Navigationsleiste wird mit dem NavController verknüpft.
        val bottomNavigationBar = binding.bottomNavigationView
        setupWithNavController(bottomNavigationBar, navController)
    }

    // Diese Methode navigiert zum nächsten Fragment (CasaFragment).
    fun navigateToNextFragment() {
        navController.navigate(R.id.casaFragment)
    }
}
