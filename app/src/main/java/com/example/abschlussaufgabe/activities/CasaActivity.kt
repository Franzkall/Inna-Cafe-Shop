package com.example.abschlussaufgabe.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.abschlussaufgabe.data.model.IMAGE_ID_EXTRA
import com.example.abschlussaufgabe.data.model.Image
import com.example.abschlussaufgabe.databinding.ActivityCasaBinding
import com.example.abschlussaufgabe.repository.CasaImageRepository.imageList

class CasaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCasaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCasaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intent.getIntExtra(IMAGE_ID_EXTRA, 1)


        val image = imageFromId(imageId)
        Log.e("CasaActivity","Ausgewählte Image: $image")
        if (image != null) {
            binding.cover1.setImageResource(image.imageSrc)
            binding.title1.text = image.description
        }
    }

    private fun imageFromId(imageId: Int): Image? {
        Log.e("CasaActivity","Images: ${imageList.size}")
        for (image in imageList) {
            if (image.id == imageId)
                return image
        }
        return null
    }
}
