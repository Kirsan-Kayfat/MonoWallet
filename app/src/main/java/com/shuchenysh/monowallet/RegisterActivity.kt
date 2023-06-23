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
                val intent = Intent(this@RegisterActivity, CheckEmailActivity::class.java)
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
        textInputEditTextEmail = findViewById(R.id.email_text_input_edit_text_forgot_password)
        textInputEditTextPassword = findViewById(R.id.password_text_input_edit_text_register)
        textViewLogin = findViewById(R.id.login_text_view_register)
        buttonRegister = findViewById(R.id.enter_button_register)

    }
}