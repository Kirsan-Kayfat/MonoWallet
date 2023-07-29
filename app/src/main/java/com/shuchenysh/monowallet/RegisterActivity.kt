package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.shuchenysh.monowallet.databinding.ActivityRegisterBinding
import com.shuchenysh.monowallet.extension.isEmailInvalid

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater).also { setContentView(it.root) }
        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        binding.registerRegisterButton.setOnClickListener {
            val login = binding.emailRegisterTextInputEdit.text.toString().trim()
            val password = binding.passwordRegisterTextInputEdit.text.toString().trim()


            if (isValidateEmailField(login) and isValidatePasswordField(password)) {
                val intent = Intent(this@RegisterActivity, CheckEmailActivity::class.java)
                startActivity(intent)
            } else {
                return@setOnClickListener
            }
        }
    }

    private fun isValidate(): Boolean {
        val login = binding.emailRegisterTextInputEdit.text.toString().trim()
        val password = binding.passwordRegisterTextInputEdit.text.toString().trim()

        return if (login.isEmpty()) {
            binding.emailRegisterTextInputLayout.error =
                getString(R.string.the_field_cannot_be_empty)
            false
        } else if (login.isEmailInvalid()) {
            binding.emailRegisterTextInputLayout.error =
                getString(R.string.email_is_invalid)
            false
        } else if (password.isEmpty()) {
            binding.passwordRegisterTextInputLayout.error =
                getString(R.string.the_field_cannot_be_empty)
            false
        } else true
    }

    private fun isValidateEmailField(text: String): Boolean {

        return when {
            text.isEmpty() -> {
                binding.emailRegisterTextInputLayout.error =
                    getString(R.string.the_field_cannot_be_empty)
                false
            }

            text.isEmailInvalid() -> {
                binding.emailRegisterTextInputLayout.error =
                    getString(R.string.email_is_invalid)
                false
            }

            else -> {
                binding.emailRegisterTextInputLayout.error = null
                true
            }
        }

    }

    private fun isValidatePasswordField(password: String): Boolean {
        return if (password.isEmpty()) {
            binding.passwordRegisterTextInputLayout.error =
                getString(R.string.the_field_cannot_be_empty)
            false
        } else {
            binding.passwordRegisterTextInputLayout.error = null
            true
        }

    }
}


