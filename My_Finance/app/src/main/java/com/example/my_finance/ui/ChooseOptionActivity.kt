package com.example.my_finance.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.my_finance.R

class ChooseOptionActivity : AppCompatActivity() {
    private lateinit var buttonLogin: Button
    private lateinit var buttonRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_option)

        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegister = findViewById(R.id.buttonRegister)

        buttonLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        buttonRegister.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }
}
