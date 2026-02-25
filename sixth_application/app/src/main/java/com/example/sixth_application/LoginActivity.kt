package com.example.sixth_application
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvGoToSignup = findViewById<TextView>(R.id.tvGoToSignup)

        btnLogin.setOnClickListener {
            // TODO: Add your authentication logic here
        }

        // "Sign Up" text → navigate to SignupActivity
        tvGoToSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
    }
}


