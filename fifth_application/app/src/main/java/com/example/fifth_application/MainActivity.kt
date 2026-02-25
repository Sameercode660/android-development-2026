package com.example.fifth_application

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonDark = findViewById<Button>(R.id.btnDark)
        val buttonLight = findViewById<Button>(R.id.btnLight)
        val mainLayout = findViewById<LinearLayout>(R.id.main)

        buttonDark.setOnClickListener {
            mainLayout.setBackgroundResource(R.color.black)
        }

        buttonLight.setOnClickListener {
            mainLayout.setBackgroundResource(R.color.white)
        }
    }
}