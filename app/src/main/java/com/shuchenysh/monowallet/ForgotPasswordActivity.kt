package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.shuchenysh.monowallet.databinding.ActivityForgotPasswordBinding
import com.shuchenysh.monowallet.extension.isEmailInvalid

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            sendLinkForgotPasswordButton.setOnClickListener {
                val text = emailForgotPasswordTextInputEdit.text.toString()
                if (!isValidateEmailField(text)) return@setOnClickListener

                val intent = Intent(
                    this@ForgotPasswordActivity,
                    ResetPasswordActivity::class.java
                )
                startActivity(intent)
                finish()
            }

            backForgotPasswordImage.setOnClickListener {
                finish()
            }
        }
    }

    private fun isValidateEmailField(email: String): Boolean {
        return when {
            email.isEmpty() -> {
                binding.emailForgotPasswordTextInputLayout.error = getString(R.string.the_field_cannot_be_empty)
                false
            }

            email.isEmailInvalid() -> {
                binding.emailForgotPasswordTextInputLayout.error = getString(R.string.email_is_invalid)
                false
            }

            else -> true
        }
    }
}