package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.shuchenysh.monowallet.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            openEmailAppResetPasswordButton.setOnClickListener {
                val password = passwordTextEditFieldResetPasswordInputEditField.text.toString().trim()
                val confirm = confirmTextInputEditFieldResetPasswordInputEditField.text.toString().trim()
                if (isMatchesPassword(password, confirm)) {
                    val intent = Intent(this@ResetPasswordActivity, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    isCorrectlyPassword(password)
                }
            }
        }
    }

    private fun isMatchesPassword(password: String, confirm: String) = password == confirm

    private fun isCorrectlyPassword(password: String) {
        with(binding) {
            if (password.length < 6) passwordTextFieldResetPasswordInputLayoutField.error =
                getString(R.string.password_less_than_six_characters)
            else {
                passwordTextFieldResetPasswordInputLayoutField.error = getString(R.string.the_passwords_don_t_match)
                confirmTextFieldResetPasswordInputLayoutField.error = getString(R.string.the_passwords_don_t_match)
            }
        }
    }
}