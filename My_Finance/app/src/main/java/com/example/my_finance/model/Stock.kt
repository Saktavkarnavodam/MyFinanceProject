package com.example.my_finance.model

class Stock(
    val name: String? = null,
    val price: Double = 0.0,
    val change: String? = null
) {

    @JvmName("getNameJvm")
    fun getName(): String? {
        return name
    }

    @JvmName("getPriceJvm")
    fun getPrice(): Double {
        return price
    }

    @JvmName("getChangeJvm")
    fun getChange(): String? {
        return change
    }
}