package com.example.assign3

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_page)

        val name = findViewById<EditText>(R.id.username)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val repeatPassword = findViewById<EditText>(R.id.repeatPassword)
        val btnRegister = findViewById<Button>(R.id.btn_login)
        val toLogin = findViewById<TextView>(R.id.login_text)

        btnRegister.setOnClickListener {
            val nameInput = name.text.toString()
            val emailInput = email.text.toString()
            val passInput = password.text.toString()
            val repeatInput = repeatPassword.text.toString()

            if (nameInput.isEmpty() || emailInput.isEmpty() || passInput.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                Toast.makeText(this, "Format email tidak valid", Toast.LENGTH_SHORT).show()
            } else if (passInput != repeatInput) {
                Toast.makeText(this, "Password tidak sama", Toast.LENGTH_SHORT).show()
            } else {
                // Simpan data ke SharedPreferences
                val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("name", nameInput)
                    putString("email", emailInput)
                    putString("password", passInput)
                    apply()
                }

                Toast.makeText(this, "Register berhasil! Silakan login.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        toLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
