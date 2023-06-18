package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    private lateinit var textInputEditTextEmail: TextInputEditText
    private lateinit var textInputEditTextPassword: TextInputEditText
    private lateinit var textViewForgotPassword: TextView
    private lateinit var textViewRegister: TextView
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()

        buttonLogin.setOnClickListener( View.OnClickListener {
            val login = textInputEditTextEmail.text.toString().trim()
            val password = textInputEditTextPassword.text.toString().trim()
            if (login.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, R.string.toast_empty_fields, Toast.LENGTH_SHORT).show()
            }
        })

        textViewRegister.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        })

        textViewForgotPassword.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
            finish()
        })
    }


    private fun initViews(){
        textInputEditTextEmail = findViewById(R.id.text_input_email_onBoarding)
        textInputEditTextPassword = findViewById(R.id.text_input_password_onBoarding)
        textViewForgotPassword = findViewById(R.id.textViewForgotPassword)
        textViewRegister = findViewById(R.id.textViewRegister)
        buttonLogin = findViewById(R.id.button_login)
    }
}