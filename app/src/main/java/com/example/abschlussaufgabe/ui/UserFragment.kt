package com.example.abschlussaufgabe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.databinding.FragmentUserBinding
import com.example.abschlussaufgabe.viewmodel.AuthViewModel
import com.example.abschlussaufgabe.viewmodel.FirestoreViewModel

/**
 * Das Fragment für die Benutzeransicht.
 */
class UserFragment : Fragment() {

    // Binding-Objekt für das Fragment
    private lateinit var binding: FragmentUserBinding

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
        binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root
    }

    /**
     * Wird aufgerufen, nachdem die Ansicht erstellt wurde.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Beobachte Änderungen im aktuellen Benutzerstatus
        authViewModel.currentUser.observe(viewLifecycleOwner) { user ->
            if (user == null) {
                // Wenn kein Benutzer angemeldet ist, navigiere zum Login-Fragment
                findNavController().navigate(R.id.loginFragment)
            } else {
                // Wenn ein Benutzer angemeldet ist, rufe seine Daten aus Firestore ab
                storeViewModel.getUserData(user.uid)
            }
        }

        // Beobachte Änderungen im aktuellen Benutzerdaten aus Firestore
        storeViewModel.currentUser.observe(viewLifecycleOwner){ user ->
            // Aktualisiere die Benutzeransicht mit den erhaltenen Benutzerdaten
            binding.tvUser.text = user.name
            binding.tvPoints.text = user.score.toString()
        }
    }
}
/**Fachlicher Kommentar:

Das UserFragment ist verantwortlich für die Benutzeransicht und zeigt Informationen über den angemeldeten Benutzer an. Hier sind die wichtigsten Funktionen:

onCreateView: In dieser Methode wird die Benutzeroberfläche des Fragments erstellt, indem das Layout aufgeblasen wird.
onViewCreated: Hier werden Daten beobachtet und aktualisiert. Der authViewModel.currentUser wird beobachtet, um den Benutzerstatus zu überwachen. Wenn kein Benutzer angemeldet ist, wird zur Login-Seite navigiert. Andernfalls werden die Benutzerdaten aus Firestore abgerufen und in der Benutzeroberfläche angezeigt.*/