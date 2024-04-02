package com.example.my_finance.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.my_finance.R
import com.example.my_finance.model.Portfolio
import com.example.my_finance.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreatePortfolioActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var createButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_portfolio)

        nameEditText = findViewById(R.id.edit_text_portfolio_name)
        descriptionEditText = findViewById(R.id.edit_text_portfolio_description)
        createButton = findViewById(R.id.button_create_portfolio)

        createButton.setOnClickListener {
            createPortfolio()
        }
    }

    private fun createPortfolio() {
        val portfolioName = nameEditText.text.toString()
        val portfolioDescription = descriptionEditText.text.toString()

        if (portfolioName.isNotEmpty() && portfolioDescription.isNotEmpty()) {
            val portfolio = Portfolio(portfolioName, portfolioDescription, 0.0, ArrayList())

            val call = ApiClient.getApiService().createPortfolio(portfolio)
            call.enqueue(object : Callback<Portfolio> {
                override fun onResponse(call: Call<Portfolio>, response: Response<Portfolio>) {
                    if (response.isSuccessful) {
                        val createdPortfolio = response.body()
                        if (createdPortfolio != null) {
                            val intent = Intent(
                                this@CreatePortfolioActivity,
                                PortfolioActivity::class.java
                            )
                            intent.putExtra("portfolio", createdPortfolio.value)
                            startActivity(intent)
                            finish()
                        }
                    } else {
                        val errorMessage = response.message()
                        Toast.makeText(
                            this@CreatePortfolioActivity,
                            "Error: $errorMessage",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<Portfolio>, t: Throwable) {
                    Toast.makeText(
                        this@CreatePortfolioActivity,
                        "Network Error: ${t.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        } else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
        }
    }

}
