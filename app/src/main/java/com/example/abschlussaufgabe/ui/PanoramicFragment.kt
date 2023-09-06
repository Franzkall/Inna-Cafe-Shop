package com.example.abschlussaufgabe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.abschlussaufgabe.activities.MainActivity
import com.example.abschlussaufgabe.databinding.FragmentViewBinding
import com.example.abschlussaufgabe.viewmodel.PanoramicViewModel

/**
 * Dieses Fragment zeigt Informationen über ein Bild an.
 */
class PanoramicFragment : Fragment() {

    // ViewModel, das für die Verwaltung der Bildinformationen verantwortlich ist
    private val model: PanoramicViewModel by viewModels()

    /**
     * Wird aufgerufen, um die Ansicht für das Fragment zu erstellen.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Das Binding-Objekt für das Fragment erstellen
        val binding = FragmentViewBinding.inflate(inflater, container, false)
        val view = binding.root

        // Den Titel der Toolbar in der MainActivity setzen
        val activity: MainActivity = requireActivity() as MainActivity
        activity.toolbarTitle.text = "Events"

        // Beobachtet die Picture-Daten im ViewModel, um die Ansicht zu aktualisieren.
        model.getPictureData().observe(viewLifecycleOwner, Observer { city ->
            // Das Bild der Stadt setzen
            binding.cityImage.setImageDrawable(
                ResourcesCompat.getDrawable(resources, city.img, requireContext().theme)
            )

            // Den Namen der Stadt setzen
            binding.CityNameTV.text = city.name

            // Die Bevölkerungszahl der Stadt setzen
            binding.cityStringTV.text = city.population.toString()
        })

        return view
    }
}
/**Fachlicher Kommentar:

Das PanoramicFragment ist für die Anzeige von Informationen über ein Bild verantwortlich. Hier sind die wichtigsten Funktionen:

onCreateView: In dieser Methode wird die Benutzeroberfläche des Fragments erstellt, indem das Layout aufgeblasen wird.
onViewCreated: Hier werden Daten im ViewModel beobachtet, um die Ansicht zu aktualisieren. Die Bildinformationen, einschließlich des Bilds, des Stadtnamens und der Bevölkerungszahl, werden aus dem ViewModel abgerufen und in der Benutzeroberfläche angezeigt. Der Titel der Toolbar in der MainActivity wird ebenfalls aktualisiert.*/