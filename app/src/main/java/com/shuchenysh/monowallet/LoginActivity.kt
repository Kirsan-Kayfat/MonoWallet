package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.shuchenysh.monowallet.databinding.ActivityLoginBinding
import com.shuchenysh.monowallet.extension.isEmailInvalid

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            enterLoginButton.setOnClickListener {
                val login = loginLoginTextInputEdit.text.toString().trim()
                val password = passwordLoginTextInputEdit.text.toString().trim()

                if (!isValidatePasswordField(password) or !isValidateEmailField(login)) {
                    return@setOnClickListener
                }

                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }

            loginLoginTextInputEdit.doAfterTextChanged {
                loginLoginTextInputLayout.error = null
            }

            passwordLoginTextInputEdit.doAfterTextChanged {
                passwordLoginTextInputLayout.error = null
            }

            registerLoginText.setOnClickListener {
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
            }

            forgotPasswordLoginText.setOnClickListener {
                val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun isValidateEmailField(email: String): Boolean {
        return when {
            email.isEmpty() -> {
                binding.loginLoginTextInputLayout.error = getString(R.string.the_field_cannot_be_empty)
                false
            }

            email.isEmailInvalid() -> {
                binding.loginLoginTextInputLayout.error = getString(R.string.email_is_invalid)
                false
            }

            else -> {
                true
            }
        }
    }

    private fun isValidatePasswordField(password: String): Boolean {
        return when {
            password.isEmpty() -> {
                binding.passwordLoginTextInputLayout.error = getString(R.string.the_field_cannot_be_empty)
                false
            }

            else -> {
                true
            }
        }
    }
}