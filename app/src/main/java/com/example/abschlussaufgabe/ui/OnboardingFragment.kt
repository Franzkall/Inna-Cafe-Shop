package com.example.abschlussaufgabe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.adapter.OnboardingItemAdapter
import com.example.abschlussaufgabe.data.model.OnboardingItem
import com.google.android.material.button.MaterialButton

/**
 * Das Fragment für das Onboarding (Einführungs-)Bildschirm.
 */
class OnboardingFragment : Fragment() {

    // Adapter für die Onboarding-Elemente
    private lateinit var onboardingItemAdapter: OnboardingItemAdapter

    /**
     * Wird aufgerufen, um die Ansicht für das Fragment zu erstellen.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_onboarding, container, false)
        setOnboardingItems(rootView)
        return rootView
    }

    /**
     * Initialisiert die Onboarding-Elemente.
     */
    private fun setOnboardingItems(rootView: View) {
        // Onboarding-Elemente erstellen
        onboardingItemAdapter = OnboardingItemAdapter(
            listOf(
                OnboardingItem(
                    onboardingImage = R.drawable.lol1,
                    title = "Willkommen",
                    description = "Danke, dass du unsere App benutzt. Ich helfe dir dabei, alle Funktionen zu nutzen."
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.lol2,
                    title = "Punkte sammeln",
                    description = "Punkte sammeln leicht gemacht: Nutze den Qr-Code Scanner, um bei jedem Einkauf Punkte zu sammeln. Diese kannst du dann gegen dein Lieblingsgetränk eintauschen. Dafür einfach anmelden oder registrieren. Das Login findest du oben links - klicke dazu auf die drei Balken."
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.lol3,
                    title = "Erlebnisse",
                    description = "Entdecke hier Bilder, Fakten, Events und viele andere faszinierende Funktionen. Wir hoffen, du hast viel Spaß damit!"
                )
            )
        )

        val onboardingViewPager = rootView.findViewById<ViewPager2>(R.id.onboardingViewPager)
        onboardingViewPager.adapter = onboardingItemAdapter

        // Klick-Listener für Weiter-Button
        rootView.findViewById<ImageView>(R.id.imageNext).setOnClickListener {
            if (onboardingViewPager.currentItem + 1 < onboardingItemAdapter.itemCount) {
                onboardingViewPager.currentItem += 1
            } else {
                navigateToCasaFragment()
            }
        }

        // Klick-Listener für Überspringen-Text
        rootView.findViewById<TextView>(R.id.textSkip).setOnClickListener {
            navigateToCasaFragment()
        }

        // Klick-Listener für Get Started Button
        rootView.findViewById<MaterialButton>(R.id.buttonGetStarted).setOnClickListener {
            navigateToCasaFragment()
        }
    }

    /**
     * Navigiert zum com.example.abschlussaufgabe.ui.CasaFragment.
     */
    private fun navigateToCasaFragment() {
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, CasaFragment())
        fragmentTransaction.commit()
    }
}

/** Fachlicher Kommentar: Dieses Fragment dient als Einführung für die App und zeigt eine Folge von Bildern und Informationen über die App-Funktionen. Benutzer können durch die Onboarding-Folien navigieren und am Ende zur Hauptansicht der App gelangen. Dieses Fragment hilft neuen Benutzern, sich mit der App vertraut zu machen. */
