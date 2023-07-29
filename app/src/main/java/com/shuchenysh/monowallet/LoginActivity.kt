package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            val login = binding.loginLoginTextInputEdit.text.toString().trim()
            val password = binding.passwordLoginTextInputEdit.text.toString().trim()
            if (!isValidateEmailField(login) and !isValidatePasswordField(password))
                return@setOnClickListener

            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.registerLoginText.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.forgotPasswordLoginText.setOnClickListener {
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidateEmailField(email: String): Boolean {
        return when {
            email.isEmpty() -> {
                binding.loginLoginTextInputLayout.error =
                    getString(R.string.the_field_cannot_be_empty)
                false
            }

            email.isEmailInvalid() -> {
                binding.loginLoginTextInputLayout.error = getString(R.string.email_is_invalid)
                false
            }

            else -> {
                binding.loginLoginTextInputLayout.error = null
                true
            }
        }
    }

    private fun isValidatePasswordField(password: String): Boolean {
        return when {
            password.isEmpty() -> {
                binding.passwordLoginTextInputLayout.error =
                    getString(R.string.the_field_cannot_be_empty)
                false
            }

            password != PASSWORD -> {
                binding.passwordLoginTextInputLayout.error =
                    getString(R.string.password_is_incorrect)
                false
            }

            else -> {
                binding.passwordLoginTextInputLayout.error = null
                true
            }
        }
    }

    companion object {
        private const val PASSWORD = "12345"
    }
}