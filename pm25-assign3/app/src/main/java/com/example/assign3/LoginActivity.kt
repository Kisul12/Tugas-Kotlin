package com.example.assign3

import android.content.Intent
import android.os.Bundle
import android.widget.*
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val toRegister = findViewById<TextView>(R.id.register_text)

        btnLogin.setOnClickListener {
            val emailInput = email.text.toString()
            val passInput = password.text.toString()

            if (emailInput.isEmpty() || passInput.isEmpty()) {
                Toast.makeText(this, "Email dan password harus diisi!", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                val savedEmail = sharedPref.getString("email", null)
                val savedPassword = sharedPref.getString("password", null)
                val savedName = sharedPref.getString("name", "User")

                if (emailInput == savedEmail && passInput == savedPassword) {
                    val user = User(savedName ?: "User", savedEmail ?: "")
                    val intent = Intent(this, LandingActivity::class.java)
                    intent.putExtra("user", user)
                    Log.d("RegisterActivity", "Akun berhasil dibuat untuk: $savedName dengan email: $savedEmail")
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Email atau password salah!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        toRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
