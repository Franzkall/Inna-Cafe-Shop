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


class OnboardingFragment : Fragment() {

    private lateinit var onboardingItemAdapter: OnboardingItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_onboarding, container, false)
        setOnboardingItems(rootView)
        return rootView
    }

    private fun setOnboardingItems(rootView: View) {
        onboardingItemAdapter = OnboardingItemAdapter(
            listOf(
                OnboardingItem(
                    onboardingImage = R.drawable.br1,
                    title = "Willkommen",
                    description = "Danke, dass du unsere App benutzt. Ich helfe dir dabei, alle Funktionen zu nutzen."
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.br2,
                    title = "Punkte sammeln",
                    description = "Punkte sammeln leicht gemacht: Nutze der Qr-Code Scanner, um bei jedem Einkauf Punkte zu sammeln.Diese kannst du dann gegen dein Lieblingsgetränk eintauschen. Dafür einfach anmelden oder registrieren.Das Login findest du oben links-klicke dazu auf die drei Balken."
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.br3,
                    title = "Erlebnisse",
                    description = "Entdecke hier Bilder, Fakten, Events und viele andere faszinierende Funktionen. Wir hoffen, du hast viel spaß damit!"
                )
            )
        )

        val onboardingViewPager = rootView.findViewById<ViewPager2>(R.id.onboardingViewPager)
        onboardingViewPager.adapter = onboardingItemAdapter

        rootView.findViewById<ImageView>(R.id.imageNext).setOnClickListener {
            if (onboardingViewPager.currentItem + 1 < onboardingItemAdapter.itemCount) {
                onboardingViewPager.currentItem += 1
            } else {
                navigateToCasaFragment()
            }
        }

        rootView.findViewById<TextView>(R.id.textSkip).setOnClickListener {
            navigateToCasaFragment()
        }

        rootView.findViewById<MaterialButton>(R.id.buttonGetStarted).setOnClickListener {
            navigateToCasaFragment()
        }
    }

    private fun navigateToCasaFragment() {
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, CasaFragment())
        fragmentTransaction.commit()
    }

}
