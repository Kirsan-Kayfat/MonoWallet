package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.shuchenysh.monowallet.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            openEmailAppResetPasswordButton.setOnClickListener {
                val password = passwordFieldResetPasswordInputEditText.text.toString().trim()
                val repeatPassword = confirmFieldResetPasswordInputEditText.text.toString().trim()

                if (!validatePasswords(password, repeatPassword)) {
                    return@setOnClickListener
                }

                val intent = Intent(this@ResetPasswordActivity, LoginActivity::class.java)
                startActivity(intent)
            }

            backResetPasswordButton.setOnClickListener {
                finish()
            }

            passwordFieldResetPasswordInputEditText.doAfterTextChanged {
                passwordFieldResetPasswordInputLayoutField.error = null
                confirmFieldResetPasswordInputLayoutField.error = null
            }

            confirmFieldResetPasswordInputEditText.doAfterTextChanged {
                confirmFieldResetPasswordInputLayoutField.error = null
            }
        }
    }

    private fun validatePasswords(password: String, repeatPassword: String): Boolean {
        return when {
            password != repeatPassword -> {
                binding.passwordFieldResetPasswordInputLayoutField.error = getString(R.string.the_passwords_don_t_match)
                binding.confirmFieldResetPasswordInputLayoutField.error = getString(R.string.the_passwords_don_t_match)
                false
            }

            password.isEmpty() -> {
                binding.passwordFieldResetPasswordInputLayoutField.error = getString(R.string.the_field_cannot_be_empty)
                false
            }

            password.length < MAX_PASSWORD_LENGTH -> {
                binding.passwordFieldResetPasswordInputLayoutField.error =
                    getString(R.string.password_less_than_six_characters)
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