package com.example.my_finance.ui

import com.example.my_finance.R
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.my_finance.adapter.PortfolioAdapter
import com.example.my_finance.model.Portfolio
import com.example.my_finance.presenter.PortfolioView

class PortfolioActivity : AppCompatActivity(), PortfolioView {
    private lateinit var portfolioListView: ListView
    private lateinit var portfolioAdapter: PortfolioAdapter
    private lateinit var presenter: PortfolioPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portfolio)
        portfolioListView = findViewById<ListView>(R.id.list_view_portfolio)
        portfolioAdapter = PortfolioAdapter(this, R.layout.portfolio_item)
        portfolioListView.setAdapter(portfolioAdapter)
        presenter = PortfolioPresenter(this)

        presenter.loadPortfolioData()
    }

    override fun displayPortfolio(portfolios: List<Portfolio?>?) {
        portfolioAdapter.clear()
        if (portfolios != null) {
            portfolioAdapter.addAll(portfolios)
        }
    }

    override fun showErrorMessage() {
        Toast.makeText(this, "Failed to display portfolio", Toast.LENGTH_SHORT).show()
    }
}