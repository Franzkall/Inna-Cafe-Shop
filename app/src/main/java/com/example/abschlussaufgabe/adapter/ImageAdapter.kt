package com.example.abschlussaufgabe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.data.model.Image
import com.example.abschlussaufgabe.databinding.ItemImageBinding

class ImageAdapter(
    private val dataset: List<Image>
) : RecyclerView.Adapter<ImageAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val image = dataset[position]
        holder.binding.imageView.setImageResource(image.imageSrc)
    }
}
