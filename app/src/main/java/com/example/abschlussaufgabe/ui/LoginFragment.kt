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
import com.example.abschlussaufgabe.databinding.FragmentLoginBinding
import com.example.abschlussaufgabe.viewmodel.AuthViewModel

/**
 * Das Fragment für den Login-Bildschirm.
 */
class LoginFragment : Fragment() {

    // Binding-Objekt für das Fragment
    private lateinit var binding: FragmentLoginBinding

    // ViewModel für die Authentifizierungsdaten
    private val viewModel: AuthViewModel by activityViewModels()

    /**
     * Wird aufgerufen, um die Ansicht für das Fragment zu erstellen.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Das Layout für das Fragment wird aufgeblasen und das Binding-Objekt initialisiert.
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    /**
     * Wird aufgerufen, sobald die Ansicht erstellt wurde.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Klick-Listener für den "Zur Registrierung" Button
        binding.btToRegister.setOnClickListener {
            // Navigiert zum Registrierungs-Fragment
            findNavController().navigate(R.id.registerFragment)

            // Setzt den Titel der Toolbar in der MainActivity
            val activity: MainActivity = requireActivity() as MainActivity
            activity.toolbarTitle.text = "Registriere dich"
        }

        // Klick-Listener für den Login-Button
        binding.btLogin.setOnClickListener {
            val email: String = binding.tietEmail.text.toString()
            val password: String = binding.tietPass.text.toString()
            if (email != "" && password != "") {
                // Ruft die Login-Funktion im ViewModel auf
                viewModel.login(email, password)
            } else {
                // Loggt einen Fehler, wenn Felder leer sind
                Log.e("ERROR", "Leeres Feld")
            }
        }

        // Beobachtet Änderungen im aktuellen Benutzerstatus
        viewModel.currentUser.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                // Navigiert zur Startseiten-Fragment, wenn Benutzer eingeloggt ist
                findNavController().navigate(R.id.userFragment)
            }

            }
        }
    }

