package com.example.abschlussaufgabe.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

/**
 * ViewModel für die Verwaltung der Authentifizierungsdaten.
 */
class AuthViewModel : ViewModel() {

    // Firebase-Authentifizierungsinstanz
    private val firebaseAuth = FirebaseAuth.getInstance()

    // LiveData für den aktuellen Benutzer
    private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUser: LiveData<FirebaseUser?>
        get() = _currentUser

    /**
     * Registriert einen neuen Benutzer mit der angegebenen E-Mail und Passwort.
     */
    fun register(email: String, password: String) {

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { authResult ->
            if (authResult.isSuccessful) {
                // Bei erfolgreicher Registrierung wird der Benutzer automatisch eingeloggt
                login(email, password)
            } else {
                Log.e("ERROR", "${authResult.exception}")
            }
        }
    }

    /**
     * Loggt den Benutzer mit der angegebenen E-Mail und Passwort ein.
     */
    fun login(email: String, password: String) {

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { authResult ->
            if (authResult.isSuccessful) {
                // Aktualisiert den aktuellen Benutzer im LiveData
                _currentUser.value = firebaseAuth.currentUser
            } else {
                Log.e("ERROR", "${authResult.exception}")
            }
        }
    }

    /**
     * Meldet den Benutzer ab.
     */
    fun logout() {
        firebaseAuth.signOut()
        // Aktualisiert den aktuellen Benutzer im LiveData
        _currentUser.value = firebaseAuth.currentUser
    }
}
