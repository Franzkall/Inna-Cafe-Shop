package com.example.abschlussaufgabe.util

/**
 * Dieses Interface definiert eine Methode zur Aktualisierung des Texts in der Toolbar.
 */
interface ToolbarTextUpdater {
    fun updateToolbarText(text: String)
}
/** Fachlicher Kommentar: Dieses Interface definiert eine Methode zur Aktualisierung des Texts in der Toolbar.

Es dient dazu, die Implementierung einer Schnittstelle zu erzwingen, um den Text in der Toolbar in verschiedenen Teilen der Anwendung dynamisch zu aktualisieren.
Durch die Verwendung dieses Interfaces können Fragmente oder Aktivitäten den Text in der Toolbar ändern, ohne direkt auf die Toolbar-Komponente zugreifen zu müssen, was die Trennung von UI und Logik fördert und die Wartbarkeit verbessert. */