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
                Log.e("AuthViewModel", "Fehler bei der Registrierung: ${authResult.exception}")
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
                Log.e("AuthViewModel", "Fehler beim Einloggen: ${authResult.exception}")
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

/** Fachlicher Kommentar: Das AuthViewModel ist verantwortlich für die Verwaltung der Authentifizierungsdaten in der App.
 * Es verwendet die Firebase-Authentifizierungsinstanz, um Benutzer zu registrieren, einzuloggen und abzumelden.
 * Das ViewModel stellt ein LiveData-Objekt bereit, das den aktuellen authentifizierten Benutzer darstellt, wodurch UI-Komponenten auf Änderungen des Benutzerstatus reagieren können.
 * Die Methode `register` ermöglicht die Registrierung eines neuen Benutzers mit E-Mail und Passwort.
 * Die Methode `login` ermöglicht das Einloggen eines vorhandenen Benutzers.
 * Die Methode `logout` ermöglicht das Abmelden des Benutzers.
 */
