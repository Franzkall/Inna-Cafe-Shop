package com.example.abschlussaufgabe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.activities.MainActivity

/**
 * Diese Aktivität dient als Startbildschirm der Anwendung.
 */
@Suppress("DEPRECATION")
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

/**
 * Fachliche Kommentar:
 *
 * Die `SplashActivity` ist die Startaktivität der Anwendung und dient als Splash-Screen, der beim Start der App angezeigt wird.
 * Ihr Hauptzweck besteht darin, dem Benutzer ein visuelles Feedback darüber zu geben, dass die Anwendung gestartet wird, während im Hintergrund verschiedene Initialisierungsprozesse ausgeführt werden können.
 *
 * Hier wird der Vollbildmodus aktiviert, um die Systemleiste auszublenden, und ein Handler verwendet, um nach einer Verzögerung von 2 Sekunden die `MainActivity` zu starten.
 * Sobald die `MainActivity` gestartet ist, wird die `SplashActivity` beendet, um sicherzustellen, dass der Benutzer nicht zurückspringen kann.
 */
