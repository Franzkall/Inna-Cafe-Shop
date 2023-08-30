package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.activities.MainActivity
import com.example.abschlussaufgabe.databinding.FragmentHomeBinding
import com.example.abschlussaufgabe.viewmodel.AuthViewModel
import com.example.abschlussaufgabe.viewmodel.FirestoreViewModel

/**
 * Das Fragment für die Startseite (Home).
 */
class HomeFragment : Fragment() {

    // Binding-Objekt für die fragment_home.xml
    private lateinit var binding: FragmentHomeBinding

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
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    /**
     * Wird aufgerufen, sobald die Ansicht erstellt wurde.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Logout-Button Klick-Listener
        binding.btLogout.setOnClickListener {
            // Ruft die Logout-Funktion im AuthViewModel auf
            authViewModel.logout()

            // Setzt den Titel der Toolbar in der MainActivity
            val activity: MainActivity = requireActivity() as MainActivity
            activity.toolbarTitle.text = "Angemeldet"
        }

        // Beobachtet Änderungen im aktuellen Benutzerstatus
        authViewModel.currentUser.observe(viewLifecycleOwner) { user ->
            if (user == null) {
                // Navigiert zur Login-Fragment, wenn kein Benutzer angemeldet ist
                findNavController().navigate(R.id.loginFragment)
            } else {
                // Ruft Benutzerdaten aus Firestore ab, wenn Benutzer angemeldet ist
                storeViewModel.getUserData(user.uid)
            }
        }

        // Beobachtet Änderungen im aktuellen Benutzerdatenstatus
        storeViewModel.currentUser.observe(viewLifecycleOwner) { user ->
            // Aktualisiert die angezeigten Benutzerinformationen auf der Ansicht
            binding.tvName.text = user.name
            binding.tvPoints.text = user.score.toString()
        }
    }
}
