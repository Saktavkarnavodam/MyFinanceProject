package com.example.my_finance.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.my_finance.R
import com.example.my_finance.presenter.RegistrationPresenter
import com.example.my_finance.presenter.RegistrationView

class RegistrationActivity : AppCompatActivity(), RegistrationView {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var presenter: RegistrationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        usernameEditText = findViewById(R.id.edit_text_username)
        passwordEditText = findViewById(R.id.edit_text_password)
        registerButton = findViewById(R.id.button_register)

        presenter = RegistrationPresenter(this)

        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            presenter.registerUser(username, password)
        }
    }

    override fun registrationSuccess() {
        Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
    }

    override fun registrationFailed() {
        Toast.makeText(this, "Registration failed! Try again.", Toast.LENGTH_SHORT).show()
    }
}