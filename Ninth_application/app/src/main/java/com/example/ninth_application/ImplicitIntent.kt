package com.example.ninth_application

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class ImplicitIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_implicit_intent)
        val camera = findViewById<CardView>(R.id.camera)
        val browser = findViewById<CardView>(R.id.browser)

        camera.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://claude.ai/chat/2e875e7b-7591-4d3f-bd3c-8df9c1e44b79")
            startActivity(intent)
        }

        browser.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }
}