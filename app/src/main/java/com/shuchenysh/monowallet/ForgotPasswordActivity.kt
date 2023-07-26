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
        binding =
            ActivityForgotPasswordBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.emailForgotPasswordTextInputEdit.doOnTextChanged { text, _, _, _ ->
        binding.sendLinkForgotPasswordButton.setOnClickListener {
            if (!isValidateEmailField(text.toString()))
                return@setOnClickListener

            val intent = Intent(
                this@ForgotPasswordActivity,
                ResetPasswordActivity::class.java
            )
            startActivity(intent)
            finish()
        }
    }

        binding.backForgotPasswordImage.setOnClickListener {
            finish()
        }
    }

    private fun isValidateEmailField(email: String): Boolean {
        return when {
            email.isEmpty() -> {
                binding.emailForgotPasswordTextInputLayout.error = "Field is not empty"
                false
            }

            email.isEmailInvalid() -> {
                binding.emailForgotPasswordTextInputLayout.error = "Email is invalid"
                false
            }

            else -> true
        }
    }
}