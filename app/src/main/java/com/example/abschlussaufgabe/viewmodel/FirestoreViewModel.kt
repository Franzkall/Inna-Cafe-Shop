package com.example.abschlussaufgabe.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.abschlussaufgabe.data.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

// Konstante für das Log-Tag
const val TAG = "FirestoreViewModel"

/**
 * ViewModel für die Verwaltung von Firestore-Daten.
 */
class FirestoreViewModel : ViewModel() {

    // LiveData für den aktuellen Benutzer
    private val _currentUser = MutableLiveData<User>()
    val currentUser: LiveData<User>
        get() = _currentUser

    // Firestore-Datenbankinstanz
    val db = Firebase.firestore

    /**
     * Fügt einen neuen Benutzer zu Firestore hinzu.
     */
    fun addNewUser(user: User) {
        // Daten des Benutzers
        val userData = mapOf(
            "name" to user.name,
            "score" to user.score
        )

        // Dokument mit Benutzerdaten in der "users"-Sammlung speichern
        db.collection("users").document(user.userID).set(userData)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    /**
     * Ruft die Benutzerdaten aus Firestore ab.
     */
    fun getUserData(userId: String) {
        val docRef = db.collection("users").document(userId)
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "Document data: ${document.data}")
                    // Benutzerobjekt mit den abgerufenen Daten erstellen
                    _currentUser.value = User(
                        userId,
                        document.data?.get("name").toString(),
                        document.data?.get("score").toString()
                    )
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }
}
