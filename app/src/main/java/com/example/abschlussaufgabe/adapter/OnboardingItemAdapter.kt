// OnboardingFragment

/**
 * Adapter-Klasse zur Verwaltung der Onboarding-Item-Daten und zur Bindung an die RecyclerView.
 */
package com.example.abschlussaufgabe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.OnboardingItem

/**
 * Adapter-Klasse zur Verwaltung der Onboarding-Item-Daten und zur Bindung an die RecyclerView.
 *
 * @param onboardingItems Die Liste der Onboarding-Items, die angezeigt werden sollen.
 */
class OnboardingItemAdapter(private val onboardingItems: List<OnboardingItem>) :
    RecyclerView.Adapter<OnboardingItemAdapter.OnboardingItemViewHolder>() {

    /**
     * View Holder-Klasse zur Aufbewahrung der UI-Elemente für jedes Onboarding-Item.
     */
    inner class OnboardingItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imageOnboarding = view.findViewById<ImageView>(R.id.imageOnboarding)
        private val textTitle = view.findViewById<TextView>(R.id.textTitle)
        private val textDescription = view.findViewById<TextView>(R.id.textDescription)

        /**
         * Bindet die Daten des Onboarding-Items an die UI-Elemente.
         */
        fun bind(onboardingItem: OnboardingItem) {
            imageOnboarding.setImageResource(onboardingItem.onboardingImage)
            textTitle.text = onboardingItem.title
            textDescription.text = onboardingItem.description
        }
    }

    /**
     * Erstellt eine neue View Holder-Instanz bei Bedarf.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.onboarding_item_container,
                parent,
                false
            )
        )
    }

    /**
     * Bindet die Daten an die UI-Elemente des View Holders.
     */
    override fun onBindViewHolder(
        holder: OnboardingItemAdapter.OnboardingItemViewHolder,
        position: Int
    ) {
        holder.bind(onboardingItems[position])
    }

    /**
     * Gibt die Gesamtzahl der Onboarding-Items zurück.
     */
    override fun getItemCount(): Int {
        return onboardingItems.size
    }
}

/**
 * Fachlicher Kommentar:
 *
 * Der OnboardingItemAdapter ist eine wichtige Komponente zur Anzeige von Onboarding-Items in einer
 * RecyclerView. Diese Adapterklasse ermöglicht es, die Daten der Onboarding-Items an die
 * zugehörigen UI-Elemente zu binden und sie in der Benutzeroberfläche des Onboarding-Fragments
 * anzuzeigen. Dies ist entscheidend für die Einführung und Erklärung von Funktionen und Inhalten in
 * der App für neue Benutzer.
 */
