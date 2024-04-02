package com.example.my_finance.presenter

import com.example.my_finance.model.Portfolio

interface PortfolioView {
    fun displayPortfolio(portfolios: List<Portfolio?>?)
    fun showErrorMessage()
}
