package com.example.abschlussaufgabe

import android.content.Context
import android.provider.MediaStore.Images
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter (
    private val context : Context,
    private val images: List <Image>
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img : ImageView = itemView.findViewById(R.id.image)
        fun bindView(image: Image) {
            img.setImageResource(image.imageSrc)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ImageViewHolder =
        ImageViewHolder(LayoutInflater.from((context)).inflate(R.layout.item_images,parent,false))

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position])

    }

    }








