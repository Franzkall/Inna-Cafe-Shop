package com.example.abschlussaufgabe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        setBottomNavigationViewVisibility(false)

        val welcomeFragment = WelcomeFragment()
        val homeFragment = HomeFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container,welcomeFragment)
            .add(R.id.fragment_container,homeFragment)
            .hide(homeFragment)
            .commit()

        Handler(Looper.getMainLooper()).postDelayed({
            supportFragmentManager.beginTransaction()
                .hide(welcomeFragment)
                .show(homeFragment)
                .commit()
        },1500)

    }
    private fun setBottomNavigationViewVisibility(visible: Boolean) {
        if (visible) {
            bottomNavigationView.visibility = View.VISIBLE
        } else {
            bottomNavigationView.visibility = View.GONE
        }
    }


}
