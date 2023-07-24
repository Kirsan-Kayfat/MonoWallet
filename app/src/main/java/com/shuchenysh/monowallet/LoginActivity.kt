package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.shuchenysh.monowallet.databinding.ActivityLoginBinding
import com.shuchenysh.monowallet.extension.isEmailInvalid

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater).also { setContentView(it.root) }
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.loginLoginButton.setOnClickListener {
            val login = binding.emailTextInputLogin.text.toString().trim()
            val password = binding.passwordTextInputEditTextLogin.text.toString().trim()
            if (!validateEmailField(login) and !validatePasswordField(password)) return@setOnClickListener

            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.registerTextViewLogin.setOnClickListener(View.OnClickListener
        {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        })

        binding.forgotPasswordTextViewLogin.setOnClickListener {
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateEmailField(email: String): Boolean {
        return when {
            email.isEmpty() -> {
                binding.emailTextInputLayoutLogin.error = "Field is not empty"
                false
            }

            email.isEmailInvalid() -> {
                binding.emailTextInputLayoutLogin.error = "Email is invalid"
                false
            }

            else -> true
        }
    }

    private fun validatePasswordField(password: String): Boolean {
        return when {
            password.isEmpty() -> {
                binding.passwordTextInputLayoutLogin.error = "Field is not empty"
                false
            }

            password != PASSWORD -> {
                binding.passwordTextInputLayoutLogin.error = "Password is incorrect"
                false
            }

            else -> true
        }
    }

    companion object {
        private const val PASSWORD = "123456"
    }
}