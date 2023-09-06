package com.example.abschlussaufgabe.activities

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
import com.example.abschlussaufgabe.util.ToolbarTextUpdater
import com.google.firebase.appcheck.ktx.appCheck
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

// MainActivity

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

            // Absichtliches Auslösen eines Absturzes (auskommentiert)
             //val crashButton = Button(this)
            // crashButton.text = "Test Crash"
             //crashButton.setOnClickListener {
             //throw RuntimeException("Test Crash") // Erzwingt einen Absturz
             //}
             //addContentView(crashButton, ViewGroup.LayoutParams(
             //ViewGroup.LayoutParams.WRAP_CONTENT))

             Firebase.initialize(context = this)
             Firebase.appCheck.installAppCheckProviderFactory(
             PlayIntegrityAppCheckProviderFactory.getInstance(),
             )
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
     *
     * @return true, wenn die App zum ersten Mal gestartet wird, andernfalls false.
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

/**
 * Fachlicher Kommentar:
 *
 * Diese Aktivität ist die Hauptaktivität der App und dient als Ausgangspunkt für die Navigation und
 * Steuerung der App. Sie enthält die Initialisierung der Benutzeroberfläche, die Steuerung der
 * Navigation zwischen verschiedenen Fragmenten und die Aktualisierung der Toolbar-Ansicht. Zudem
 * wird überprüft, ob die App zum ersten Mal gestartet wird, und entsprechend navigiert.
 */
