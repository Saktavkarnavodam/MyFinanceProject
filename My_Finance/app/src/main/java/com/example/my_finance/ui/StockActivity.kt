package com.example.my_finance.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.my_finance.R
import com.example.my_finance.model.Stock
import com.example.my_finance.presenter.StockActivityPresenter
import com.example.my_finance.presenter.StockView

class StockActivity: AppCompatActivity(), StockView {
    private var stockInfoTextView: TextView? = null
    private lateinit var presenter: StockActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock)
        stockInfoTextView = findViewById<TextView>(R.id.text_view_stock_info)

        presenter = StockActivityPresenter(this)
        presenter.loadStockMarketData()
    }

    override fun displayStocks(stocks: List<Stock?>?) {
        val stringBuilder = StringBuilder()
        stocks?.forEach { stock ->
            stringBuilder.append("Stock Name: ").append(stock?.getName())
                .append("\nPrice: ").append(stock?.getPrice())
                .append("\nChange: ").append(stock?.getChange())
                .append("\n\n")
        }
        stockInfoTextView?.text = stringBuilder.toString()
    }

    override fun showErrorMessage() {
        stockInfoTextView?.text = "Failed to load stock market data."
    }
}