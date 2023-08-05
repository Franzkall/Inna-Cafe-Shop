package com.example.abschlussaufgabe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


         Thread.sleep(2000)


        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}


