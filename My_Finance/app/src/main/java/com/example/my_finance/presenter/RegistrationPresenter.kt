package com.example.my_finance.presenter


import com.example.my_finance.model.User
import com.example.my_finance.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegistrationPresenter(private val view: RegistrationView) {
    fun registerUser(username: String?, password: String?) {
        val user = User(username!!, password!!)
        ApiClient.getApiService().registerUser(user)?.enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                if (response.isSuccessful) {
                    view.registrationSuccess()
                } else {
                    view.registrationFailed()
                }
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
                view.registrationFailed()
            }
        })
    }
}
