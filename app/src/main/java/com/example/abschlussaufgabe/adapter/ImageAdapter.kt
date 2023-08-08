package com.example.abschlussaufgabe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.data.model.Image
import com.example.abschlussaufgabe.databinding.ItemImageBinding

// Adapter-Klasse, die Bilder in einer RecyclerView anzeigt
class ImageAdapter(
    private val dataset: List<Image> // Liste der anzuzeigenden Bilder
) : RecyclerView.Adapter<ImageAdapter.ItemViewHolder>() {

    // ViewHolder-Klasse, die die Darstellung eines Bildes verwaltet
    class ItemViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)

    // Erstellt eine neue ViewHolder-Instanz
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    // Gibt die Anzahl der Bilder im Dataset zurück
    override fun getItemCount(): Int {
        return dataset.size
    }

    // Bindet Daten an einen ViewHolder
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val image = dataset[position]
        holder.binding.imageView.setImageResource(image.imageSrc) // Setzt die Bildquelle im ImageView
    }
}