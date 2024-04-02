package com.example.my_finance.presenter

import com.example.my_finance.model.Stock

interface StockView {
    fun displayStocks(stocks: List<Stock?>?)
    fun showErrorMessage()
}
