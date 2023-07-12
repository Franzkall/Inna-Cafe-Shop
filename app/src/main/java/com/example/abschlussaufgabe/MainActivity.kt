package com.example.abschlussaufgabe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf(
            Image(R.drawable.bild1),
            Image(R.drawable.inside),
            Image(R.drawable.bild4),
            Image(R.drawable.caffe),
            Image(R.drawable.new_logo),
            Image(R.drawable.lavazza)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.imagesRecyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this, images)
    }
}


