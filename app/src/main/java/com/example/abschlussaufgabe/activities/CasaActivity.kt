package com.example.abschlussaufgabe.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.abschlussaufgabe.data.model.IMAGE_ID_EXTRA
import com.example.abschlussaufgabe.data.model.Image
import com.example.abschlussaufgabe.databinding.ActivityCasaBinding
import com.example.abschlussaufgabe.repository.CasaImageRepository.imageList

//CasaFragment

/**
 * Diese Aktivität zeigt Details zu einem ausgewählten Bild an.
 */
class CasaActivity : AppCompatActivity() {

    // Binding-Objekt für die Aktivität
    private lateinit var binding: ActivityCasaBinding

    /**
     * Wird aufgerufen, wenn die Aktivität erstellt wird.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Das Layout für die Aktivität wird aufgeblasen und das Binding-Objekt initialisiert.
        binding = ActivityCasaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Die ID des ausgewählten Bildes wird aus den Intent-Extras gelesen.
        val imageId = intent.getIntExtra(IMAGE_ID_EXTRA, 1)

        // Das entsprechende Bild wird anhand der ID aus der Liste geladen.
        val image = imageFromId(imageId)
        Log.e("CasaActivity","Ausgewählte Image: $image")
        if (image != null) {
            // Die Benutzeroberfläche wird mit Informationen über das Bild aktualisiert.
            binding.cover1.setImageResource(image.imageSrc)
            binding.title1.text = image.description
            binding.text1.text = image.text
        }
    }

    /**
     * Diese Methode sucht nach einem Bild in der Liste basierend auf seiner ID.
     *
     * @param imageId Die ID des gesuchten Bildes.
     * @return Das gefundene Bild oder null, wenn es nicht gefunden wurde.
     */
    private fun imageFromId(imageId: Int): Image? {
        Log.e("CasaActivity","Images: ${imageList.size}")
        for (image in imageList) {
            if (image.id == imageId)
                return image
        }
        return null
    }
}
/**
 * Fachlicher Kommentar:
 *
 * Diese Aktivität dient dazu, die Details eines ausgewählten Bildes anzuzeigen. Sie extrahiert die
 * Bild-ID aus den Intent-Extras, sucht das entsprechende Bild in einer Liste von Bildern und
 * aktualisiert die Benutzeroberfläche mit den Details des gefundenen Bildes. Dieser Code ist ein
 * Beispiel für die Anzeige von Bildern und Texten in einer Android-Anwendung.
 */

