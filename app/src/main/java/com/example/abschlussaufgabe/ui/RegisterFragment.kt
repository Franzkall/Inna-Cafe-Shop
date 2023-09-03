package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.activities.MainActivity
import com.example.abschlussaufgabe.data.model.User
import com.example.abschlussaufgabe.databinding.FragmentRegisterBinding
import com.example.abschlussaufgabe.viewmodel.AuthViewModel
import com.example.abschlussaufgabe.viewmodel.FirestoreViewModel

/**
 * Das Fragment für die Registrierungsseite.
 */
class RegisterFragment : Fragment() {

    // Binding-Objekt für das Fragment
    private lateinit var binding: FragmentRegisterBinding

    // ViewModel für die Authentifizierungsdaten
    private val authViewModel: AuthViewModel by activityViewModels()

    // ViewModel für Firestore-Daten
    private val storeViewModel: FirestoreViewModel by activityViewModels()

    /**
     * Wird aufgerufen, um die Ansicht für das Fragment zu erstellen.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Das Layout für das Fragment wird aufgeblasen und das Binding-Objekt initialisiert.
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    /**
     * Wird aufgerufen, sobald die Ansicht erstellt wurde.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Klick-Listener für den "Zurück zum Login" Button
        binding.btBack.setOnClickListener {
            // Navigiert zum Login-Fragment
            findNavController().navigate(R.id.loginFragment)

            // Setzt den Titel der Toolbar in der MainActivity
            val activity: MainActivity = requireActivity() as MainActivity
            activity.toolbarTitle.text = "Login"
        }

        // Klick-Listener für den Registrierungs-Button
        binding.btRegister.setOnClickListener {
            val email: String = binding.tietEmail.text.toString()
            val password: String = binding.tietPass.text.toString()
            if (email != "" && password != "") {
                // Ruft die Registrierungsfunktion im ViewModel auf
                authViewModel.register(email, password)
            } else {
                // Loggt einen Fehler, wenn Felder leer sind
                Log.e("ERROR", "Leeres Feld")
            }
        }

        // Beobachtet Änderungen im aktuellen Benutzerstatus
        authViewModel.currentUser.observe(viewLifecycleOwner) { firebaseUser ->
            if (firebaseUser != null) {
                val user = User(
                    firebaseUser.uid,
                    binding.tietEmail.text.toString(),
                    binding.tietPass.text.toString().toInt()

                )

                // Fügt den neuen Benutzer zu Firestore hinzu
                storeViewModel.addNewUser(user)

                // Navigiert zum Hauptbildschirm nach erfolgreicher Registrierung
                findNavController().navigate(R.id.userFragment)
            }
        }
    }
}
