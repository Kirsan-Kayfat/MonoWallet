package com.shuchenysh.monowallet

import android.content.Context
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

        buttonLogin.setOnClickListener(View.OnClickListener {
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

    private fun initViews() {
        textInputEditTextEmail = findViewById(R.id.email_text_input_login)
        textInputEditTextPassword = findViewById(R.id.password_text_input_edit_text_login)
        textViewForgotPassword = findViewById(R.id.forgot_password_text_view_login)
        textViewRegister = findViewById(R.id.register_text_view_login)
        buttonLogin = findViewById(R.id.button_login)
    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}