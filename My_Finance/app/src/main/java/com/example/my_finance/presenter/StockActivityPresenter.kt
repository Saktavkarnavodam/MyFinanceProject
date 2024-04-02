package com.example.my_finance.presenter


import com.example.my_finance.model.Stock
import com.example.my_finance.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class StockActivityPresenter(private val view: StockView) {
    fun loadStockMarketData() {
        val call: Call<List<Stock>> = ApiClient.getApiService().getStocks()
        call.enqueue(object : Callback<List<Stock>> {
            override fun onResponse(call: Call<List<Stock>>, response: Response<List<Stock>>) {
                if (response.isSuccessful) {
                    view.displayStocks(response.body())
                } else {
                    view.showErrorMessage()
                }
            }

            override fun onFailure(call: Call<List<Stock>>, t: Throwable) {
                view.showErrorMessage()
            }
        })
    }
}
