package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.databinding.ActivityMainBinding
import com.example.abschlussaufgabe.util.ToolbarTextUpdater

/**
 * Die Hauptaktivität der Anwendung, die die Navigation und das Layout verwaltet.
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
        // Das Layout der Aktivität wird durch Data Binding gesetzt.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        toolbarTitle = binding.textView2

        // Der NavHostFragment und der zugehörige NavController werden initialisiert.
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        // Die untere Navigationsleiste wird mit dem NavController verknüpft.
        val bottomNavigationBar = binding.bottomNavigationView
        setupWithNavController(bottomNavigationBar, navController)
    }

    /**
     * Aktualisiert den Text in der Toolbar.
     */
    override fun updateToolbarText(text: String) {
        supportActionBar?.title = text
    }
}
