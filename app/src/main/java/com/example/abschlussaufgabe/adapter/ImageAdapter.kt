package com.example.abschlussaufgabe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.data.model.Image
import com.example.abschlussaufgabe.databinding.ItemImageBinding
import com.example.abschlussaufgabe.ui.CasaFragment

// CasaFragment

/**
 * Adapter-Klasse, die Bilder in einer RecyclerView anzeigt.
 *
 * @param image Die Liste der anzuzeigenden Bilder.
 * @param imageClickListener Der Listener für Klick-Ereignisse auf Bilder.
 */
class ImageAdapter(
    private val image: MutableList<Image>,
    private val imageClickListener: CasaFragment
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindImage(image[position])
    }

    override fun getItemCount(): Int  = image.size

    /**
     * ViewHolder-Klasse, die die Darstellung eines Bildes verwaltet.
     */
    inner class ImageViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Bindet ein Bild an den ViewHolder.
         */
        fun bindImage(image: Image) {
            binding.imageView.setImageResource(image.imageSrc) // Setzt das Bild im ImageView
            binding.textView4.text = image.description            // Setzt die Bildbeschreibung im TextView

            // Fügt einen Klick-Listener zum CardView hinzu, um auf Bild-Klicks zu reagieren
            binding.ImageCardView.setOnClickListener {
                imageClickListener.onClick(image) // Ruft die Methode auf, wenn ein Bild geklickt wird
            }
        }
    }
}

/**
 * Fachlicher Kommentar:
 *
 * Der ImageAdapter ist eine wichtige Komponente in der RecyclerView-Ansicht des CasaFragments. Er
 * dient dazu, Bilder in einer scrollbaren Liste anzuzeigen. Dieser Adapter ermöglicht es, die
 * Bilder in der Benutzeroberfläche anzuzeigen und auf Klick-Ereignisse auf Bilder zu reagieren. Der
 * Adapter spielt eine zentrale Rolle bei der Darstellung von Bildern in der CasaFragment-Ansicht.
 */
