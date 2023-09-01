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
                val confirm = confirmFieldResetPasswordInputEditText.text.toString().trim()

                if (password.isNotEmpty() && confirm.isNotEmpty() && password == confirm) {
                    val intent = Intent(this@ResetPasswordActivity, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    isPasswordCorrect(password)
                    isConfirmCorrect(confirm)
                    return@setOnClickListener
                }
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

    private fun isPasswordCorrect(password: String) {
        with(binding) {
            if (password.isEmpty()) {
                passwordFieldResetPasswordInputLayoutField.error = getString(R.string.the_field_cannot_be_empty)
            } else if (password.length < 6) {
                passwordFieldResetPasswordInputLayoutField.error =
                    getString(R.string.password_less_than_six_characters)
            } else {
                passwordFieldResetPasswordInputLayoutField.error = getString(R.string.the_passwords_don_t_match)
            }
        }
    }

    private fun isConfirmCorrect(confirm: String) {
        with(binding) {
            if (confirm.isEmpty()) {
                confirmFieldResetPasswordInputLayoutField.error = getString(R.string.the_field_cannot_be_empty)
            } else {
                confirmFieldResetPasswordInputLayoutField.error = getString(R.string.the_passwords_don_t_match)
            }
        }
    }
}