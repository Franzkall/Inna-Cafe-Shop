package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.databinding.ActivityMainBinding
import com.example.abschlussaufgabe.db.RefreshmentRepository
import com.example.abschlussaufgabe.util.ToolbarTextUpdater

class MainActivity : AppCompatActivity(), ToolbarTextUpdater {

    private lateinit var navController: NavController

    lateinit var toolbarTitle: TextView
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        toolbarTitle = binding.textView2
        binding.fabMenu.setOnClickListener {
            binding.drawer.open()

            val repository = RefreshmentRepository.getInstance(this)
            repository.prepopulateDB()
           // Crashlytics
            val crashButton = Button(this)
            crashButton.text = "Test Crash"
            crashButton.setOnClickListener {
                throw RuntimeException("Test Crash") // Force a crash
            }

            addContentView(crashButton, ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT))
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        binding.navigationView.setupWithNavController(navController)

        // Hier wird die Navigation basierend auf dem Zustand der App gesteuert
        if (savedInstanceState == null) {
            if (isFirstTimeLaunch()) {
                navController.navigate(R.id.onboardingFragment)
            } else {
                navController.navigate(R.id.casaFragment)
            }
        }

        // Die untere Navigationsleiste wird mit dem NavController verknüpft.
        val bottomNavigationBar = binding.bottomNavigationView
        setupWithNavController(bottomNavigationBar, navController)
    }

    override fun updateToolbarText(text: String) {
        supportActionBar?.title = text
    }

    private fun isFirstTimeLaunch(): Boolean {
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val isFirstTime = sharedPreferences.getBoolean("isFirstTime", true)

        if (isFirstTime) {
            val editor = sharedPreferences.edit()
            editor.putBoolean("isFirstTime", false)
            editor.apply()
        }

        return isFirstTime
    }

}
