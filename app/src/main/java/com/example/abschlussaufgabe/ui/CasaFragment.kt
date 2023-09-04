package com.example.abschlussaufgabe.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.abschlussaufgabe.activities.CasaActivity
import com.example.abschlussaufgabe.activities.MainActivity
import com.example.abschlussaufgabe.adapter.ImageAdapter
import com.example.abschlussaufgabe.data.model.IMAGE_ID_EXTRA
import com.example.abschlussaufgabe.data.model.Image
import com.example.abschlussaufgabe.databinding.FragmentCasaBinding
import com.example.abschlussaufgabe.repository.CasaImageRepository

/**
 * Fragment-Klasse für die Casa-Ansicht.
 */
class CasaFragment : Fragment() {

    // Binding-Objekt für das Fragment
    private lateinit var binding: FragmentCasaBinding

    // Lazy initialisierte Instanz des ImageAdapters
    private val imageAdapter: ImageAdapter by lazy { ImageAdapter(CasaImageRepository.imageList, this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Das Layout für dieses Fragment wird aufgeblasen, und das Binding-Objekt wird initialisiert.
        binding = FragmentCasaBinding.inflate(inflater, container, false)

        // Die Toolbar-Titel wird aktualisiert
        val activity: MainActivity = requireActivity() as MainActivity
        activity.toolbarTitle.text = "Willkommen"

        // Die RecyclerView-Einstellungen werden konfiguriert
        binding.imagesRecyclerview.apply {
            layoutManager = GridLayoutManager(requireContext(), 1)
            adapter = imageAdapter
        }

        return binding.root
    }

    /**
     * Methode, die aufgerufen wird, wenn auf ein Bild geklickt wird.
     */
    fun onClick(image: Image) {
        try {
            Log.e("Casa", "${image.id}")
            val intent = Intent(requireContext(), CasaActivity::class.java)
            intent.putExtra(IMAGE_ID_EXTRA, image.id)
            startActivity(intent)
        } catch (e: Exception) {
            Log.e("casaFragment", "Fehler beim Klicken auf das Bild: ${e.message}")
        }
    }
}

/**
 * Fachlicher Kommentar:
 *
 * Das `CasaFragment` ist ein Fragment der Casa-Ansicht in der App. Es zeigt eine Liste von Bildern an, und wenn auf ein Bild geklickt wird, wird
 * der Benutzer zur `CasaActivity` weitergeleitet. Das Fragment verwendet ein Lazy-initialisiertes `ImageAdapter`-Objekt zur Anzeige der Bilder in
 * einer RecyclerView. Das Fragment kümmert sich auch um die Aktualisierung der Toolbar-Titel. Es handelt sich um eine wichtige Benutzeroberflächenkomponente
 * in der App, die den Benutzern den Zugriff auf verschiedene Bilder und Informationen ermöglicht.
 */
