package com.example.my_finance.network


import com.example.my_finance.model.Portfolio
import com.example.my_finance.model.Stock
import com.example.my_finance.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    @POST("/api/user/register")
    fun registerUser(@Body user: User?): Call<User?>?

    @POST("/api/user/login")
    fun loginUser(@Body user: User?): Call<User?>?

    @GET("/api/user/stocks")
    fun getStocks(): Call<List<Stock>>

    @GET("/api/user/portfolios")
    fun getPortfolios(): Call<List<Portfolio>>

    @POST("/api/user/create_portfolio")
    fun createPortfolio(@Body portfolio: Portfolio): Call<Portfolio>
}
