package com.example.abschlussaufgabe.data.model

// OnboardingFragment
/**
 * Datenklasse für Onboarding-Elemente.
 */
data class OnboardingItem(
    val onboardingImage: Int, // Die Quelle (Resource-ID) des Onboarding-Bildes
    val title: String,       // Der Titel des Onboarding-Elements
    val description: String  // Die Beschreibung des Onboarding-Elements
)

/**
 * Fachlicher Kommentar:
 *
 * Diese Datenklasse, `OnboardingItem`, wird verwendet, um Informationen über Onboarding-Elemente in der App zu speichern.
 * Jedes `OnboardingItem`-Objekt enthält die Quelle des Onboarding-Bildes (normalerweise als Resource-ID), einen Titel und eine
 * Beschreibung für das Onboarding-Element. Diese Informationen werden normalerweise im "OnboardingFragment" verwendet, um dem Benutzer
 * Informationen und Anleitungen beim ersten Start der App bereitzustellen. Die Verwendung dieser Datenklasse erleichtert die Strukturierung
 * und Anzeige von Onboarding-Inhalten in der App.
 */
