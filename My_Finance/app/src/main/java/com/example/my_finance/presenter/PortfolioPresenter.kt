package com.example.my_finance.ui

import com.example.my_finance.model.Portfolio
import com.example.my_finance.network.ApiClient
import com.example.my_finance.presenter.PortfolioView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PortfolioPresenter(private val view: PortfolioView) {
    fun loadPortfolioData() {
        val call: Call<List<Portfolio>> = ApiClient.getApiService().getPortfolios()
        call?.enqueue(object : Callback<List<Portfolio>?> {
            override fun onResponse(call: Call<List<Portfolio>?>, response: Response<List<Portfolio>?>) {
                if (response.isSuccessful) {
                    view.displayPortfolio(response.body())
                } else {
                    view.showErrorMessage()
                }
            }

            override fun onFailure(call: Call<List<Portfolio>?>, t: Throwable) {
                view.showErrorMessage()
            }
        })
    }
}
