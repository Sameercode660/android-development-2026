package com.example.sixth_application


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val btnSignup = findViewById<Button>(R.id.btnSignup)
        val btnBack = findViewById<TextView>(R.id.btnBack)
        val tvGoToLogin = findViewById<TextView>(R.id.tvGoToLogin)

        // Back arrow → goes back to the previous screen
        btnBack.setOnClickListener {
            finish()
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        // "Sign In" text → navigate to LoginActivity
        tvGoToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        btnSignup.setOnClickListener {
            // TODO: Add your registration logic here
        }
    }
}