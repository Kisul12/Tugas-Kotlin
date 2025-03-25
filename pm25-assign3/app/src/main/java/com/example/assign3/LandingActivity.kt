package com.example.assign3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_page)

        val user = intent.getParcelableExtra<User>("user")
        val welcomeText = findViewById<TextView>(R.id.welcome_text)

        welcomeText.text = "Halo Selamat Datang, ${user?.name}!"
    }
}
