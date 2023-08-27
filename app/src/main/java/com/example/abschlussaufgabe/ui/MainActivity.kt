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

/**
 * Die Hauptaktivität der App.
 */
class MainActivity : AppCompatActivity(), ToolbarTextUpdater {

    private lateinit var navController: NavController

    lateinit var toolbarTitle: TextView
    private lateinit var binding: ActivityMainBinding

    /**
     * Wird aufgerufen, wenn die Aktivität erstellt wird.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        toolbarTitle = binding.textView2

        // Klick-Listener für das FAB-Menü
        binding.fabMenu.setOnClickListener {
            // Öffnet die Navigations-Schublade
            binding.drawer.open()

            // Initialisiert die Datenbank mit vordefinierten Werten
            val repository = RefreshmentRepository.getInstance(this)
            repository.prepopulateDB()

            // Absichtliches Auslösen eines Absturzes (auskommentiert)
            // val crashButton = Button(this)
             //crashButton.text = "Test Crash"
            // crashButton.setOnClickListener {
               //  throw RuntimeException("Test Crash") // Erzwingt einen Absturz
            // }
             //addContentView(crashButton, ViewGroup.LayoutParams(
               //  ViewGroup.LayoutParams.MATCH_PARENT,
              //   ViewGroup.LayoutParams.WRAP_CONTENT))
        }

        // Sucht das NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        // Verknüpft die Navigationsansicht mit dem NavController
        binding.navigationView.setupWithNavController(navController)

        // Navigationssteuerung basierend auf dem App-Zustand
        if (savedInstanceState == null) {
            if (isFirstTimeLaunch()) {
                navController.navigate(R.id.onboardingFragment)
            } else {
                navController.navigate(R.id.casaFragment)
            }
        }

        // Verknüpft die untere Navigationsleiste mit dem NavController
        val bottomNavigationBar = binding.bottomNavigationView
        setupWithNavController(bottomNavigationBar, navController)
    }

    /**
     * Aktualisiert den Titel der Toolbar.
     */
    override fun updateToolbarText(text: String) {
        supportActionBar?.title = text
    }

    /**
     * Überprüft, ob die App zum ersten Mal gestartet wird.
     */
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
