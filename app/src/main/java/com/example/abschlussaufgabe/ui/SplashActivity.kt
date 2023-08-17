package com.example.abschlussaufgabe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.example.abschlussaufgabe.R

/**
 * Diese Aktivität dient als Startbildschirm der Anwendung.
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Der Status der Systemleiste wird auf den Vollbildmodus gesetzt.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAGS_CHANGED
        )

        // Ein Handler wird verwendet, um die MainActivity nach einer Verzögerung zu starten.
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Die SplashActivity wird beendet, um nicht zurückkehren zu können.
        }, 2000) // Die Verzögerung beträgt 2000 Millisekunden (2 Sekunden).
    }
}
