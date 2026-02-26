package com.example.eighth_application

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dialButton = findViewById<Button>(R.id.dialButton)

        dialButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = "tel:+916394867435".toUri()
            startActivity(intent)
        }
    }
}