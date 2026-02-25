package com.example.third_application

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnUpload = findViewById<Button>(R.id.btnUpload)
        val btnDownload = findViewById<Button>(R.id.btnDownload)


        btnUpload.setOnClickListener {
            Toast.makeText(applicationContext, "Uploading..", Toast.LENGTH_LONG).show()
        }

        btnDownload.setOnClickListener {
            Toast.makeText(applicationContext, "Downloading...", Toast.LENGTH_SHORT).show()
        }

    }
}