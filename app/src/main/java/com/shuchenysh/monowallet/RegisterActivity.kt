package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {

    private lateinit var textInputEditTextEmail: TextInputEditText
    private lateinit var textInputEditTextPassword: TextInputEditText
    private lateinit var textViewLogin: TextView
    private lateinit var buttonRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initViews()

        textViewLogin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        })

        buttonRegister.setOnClickListener(View.OnClickListener {
            val login = textInputEditTextEmail.text.toString().trim()
            val password = textInputEditTextPassword.text.toString().trim()
            if (login.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    this,
                    R.string.toast_empty_fields,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun initViews() {
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail)
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword)
        textViewLogin = findViewById(R.id.textViewLogin)
        buttonRegister = findViewById(R.id.buttonRegister)

    }
}