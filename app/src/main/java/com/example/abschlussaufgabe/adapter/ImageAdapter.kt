package com.example.abschlussaufgabe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.data.model.Image
import com.example.abschlussaufgabe.databinding.ItemImageBinding
import com.example.abschlussaufgabe.ui.CasaFragment

// CasaFragment

/**
 * Der Adapter-Klasse, die Bilder in einer RecyclerView anzeigt.
 *
 * @param imageList Die Liste der anzuzeigenden Bilder
 * @param imageClickListener Der Listener für Klick-Ereignisse auf Bilder
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
    
    inner class ImageViewHolder(private val binding: ItemImageBinding) :
            RecyclerView.ViewHolder(binding.root) {
                
                fun bindImage(image: Image) {
                    binding.imageView.setImageResource(image.imageSrc)
                    binding.textView4.text = image.description
                    
                    binding.ImageCardView.setOnClickListener {
                        imageClickListener.onClick(image)
                    }
                }
            }
        
    

    
    }

    

