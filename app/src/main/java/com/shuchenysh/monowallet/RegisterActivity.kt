package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import com.shuchenysh.monowallet.databinding.ActivityRegisterBinding
import com.shuchenysh.monowallet.extension.isEmailInvalid

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            enterRegisterButton.setOnClickListener {
                val login = emailFieldRegisterText.text.toString().trim()
                val password = passwordRegisterTextInputEdit.text.toString().trim()

                if (!isValidateEmailField(login) or !isValidatePasswordField(password)) {
                    return@setOnClickListener
                }
                val intent = Intent(this@RegisterActivity, CheckEmailActivity::class.java)
                startActivity(intent)
            }

            emailFieldRegisterText.doAfterTextChanged {
                emailFieldRegisterContainer.error = null
            }

            passwordRegisterTextInputEdit.doAfterTextChanged {
                passwordRegisterTextInputLayout.error = null
            }
        }
    }

    private fun isValidateEmailField(text: String): Boolean {
        return when {
            text.isEmpty() -> {
                binding.emailFieldRegisterContainer.error = getString(R.string.the_field_cannot_be_empty)
                false
            }

            text.isEmailInvalid() -> {
                binding.emailFieldRegisterContainer.error = getString(R.string.email_is_invalid)
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
                binding.passwordRegisterTextInputLayout.error = getString(R.string.the_field_cannot_be_empty)
                false
            }

            password.length < MAX_PASSWORD_LENGTH -> {
                binding.passwordRegisterTextInputLayout.error = getString(R.string.password_less_than_six_characters)
                false
            }

            else -> {
                true
            }
        }
    }

    companion object {
        private const val MAX_PASSWORD_LENGTH = 6
    }
}


