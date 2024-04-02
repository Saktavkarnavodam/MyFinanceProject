package com.example.my_finance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.my_finance.model.Stock
import com.example.my_finance.presenter.StockActivityPresenter
import com.example.my_finance.presenter.StockView
import com.example.my_finance.ui.LoginActivity
import com.example.my_finance.ui.RegistrationActivity

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_option)

        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)

        buttonLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        buttonRegister.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }
}
