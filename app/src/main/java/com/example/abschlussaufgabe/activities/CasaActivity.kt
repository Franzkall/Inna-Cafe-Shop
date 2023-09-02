package com.example.abschlussaufgabe.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.abschlussaufgabe.data.DataSource
import com.example.abschlussaufgabe.data.model.IMAGE_ID_EXTRA
import com.example.abschlussaufgabe.data.model.Image
import com.example.abschlussaufgabe.databinding.ActivityCasaBinding

class CasaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCasaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCasaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intent.getIntExtra(IMAGE_ID_EXTRA, 1)

        val imageList = DataSource().loadImages()
        val image = imageFromId(imageList, imageId)

        if (image != null) {
            binding.cover1.setImageResource(image.imageSrc)
            binding.title1.text = image.description
        }
    }

    private fun imageFromId(imageList: List<Image>, imageId: Int): Image? {
        for (image in imageList) {
            if (image.imageSrc == imageId)
                return image
        }
        return null
    }
}
