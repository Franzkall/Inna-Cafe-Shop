package com.example.abschlussaufgabe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.data.model.Image
import com.example.abschlussaufgabe.databinding.ItemImageBinding
// CasaFragment
/**
 * Der Adapter-Klasse, die Bilder in einer RecyclerView anzeigt.
 *
 * @param dataset Die Liste der anzuzeigenden Bilder
 */
class ImageAdapter(private val dataset: List<Image>) : RecyclerView.Adapter<ImageAdapter.ItemViewHolder>() {

    /**
     * ViewHolder-Klasse, die die Darstellung eines Bildes verwaltet.
     *
     * @param binding Das Datenbindungsobjekt für die einzelnen Listenelemente
     */
    class ItemViewHolder(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {

        /**
         * Bindet die Daten des Bildes an den ViewHolder.
         *
         * @param image Das Image-Objekt, das angezeigt werden soll
         */
        fun bind(image: Image) {
            // Setzt die Bildquelle im ImageView
            binding.imageView.setImageResource(image.imageSrc)
            // Setzt die Beschreibung im TextView
            binding.textView4.text = image.description
        }
    }

    /**
     * Wird aufgerufen, wenn ein neuer ViewHolder erstellt werden muss.
     *
     * @param parent Die Elternansicht, in der der ViewHolder platziert wird
     * @param viewType Der Typ der Ansicht
     * @return Ein neuer ViewHolder, der die View enthält
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    /**
     * Gibt die Anzahl der Elemente im Datensatz zurück.
     *
     * @return Die Anzahl der Elemente im Datensatz
     */
    override fun getItemCount(): Int {
        return dataset.size
    }

    /**
     * Bindet die Daten an einen ViewHolder.
     *
     * @param holder Der ViewHolder, an den die Daten gebunden werden
     * @param position Die Position des Elements im Datensatz
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val image = dataset[position]
        holder.bind(image)
    }
}
