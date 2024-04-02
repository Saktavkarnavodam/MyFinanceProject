package com.example.my_finance.model

class Portfolio(
    val name: String? = null,
    val description: String? = null,
    val value: Double = 0.0,
    val stocks: List<Stock>? = null
)