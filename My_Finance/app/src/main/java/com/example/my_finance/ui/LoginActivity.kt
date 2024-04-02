package com.example.my_finance.ui


import com.example.my_finance.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.my_finance.model.User
import com.example.my_finance.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        usernameEditText = findViewById<EditText>(R.id.edit_text_username)
        passwordEditText = findViewById<EditText>(R.id.edit_text_password)
        loginButton = findViewById<Button>(R.id.button_login)
        loginButton.setOnClickListener(View.OnClickListener {
            val username = usernameEditText.getText().toString().trim { it <= ' ' }
            val password = passwordEditText.getText().toString().trim { it <= ' ' }

            val user = User(username, password)

            loginUser(user)
        })
    }

    private fun loginUser(user: User) {
        val call: Call<User?>? = ApiClient.getApiService().loginUser(user)
        if (call != null) {
            call.enqueue(object : Callback<User?> {
                override fun onResponse(call: Call<User?>, response: Response<User?>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@LoginActivity, "Login successful!", Toast.LENGTH_SHORT)
                            .show()
                        //Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        //startActivity(intent);
                        //finish();
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Login failed! Invalid username or password.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<User?>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Error: " + t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
