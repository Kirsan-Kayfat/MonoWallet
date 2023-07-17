package com.shuchenysh.monowallet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.shuchenysh.monowallet.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater).also { setContentView(it.root) }
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.emailTextInputLogin.doOnTextChanged { text, start, before, count ->
            if (text.toString().endsWith("@mail.ru") ||
                text.toString().endsWith("@gmail.com") ||
                text.toString().endsWith("@bk.ru") ||
                text.toString().endsWith("@yandex.ru")
            ) {
                binding.emailTextInputLayoutLogin.error = null
            } else {
                binding.emailTextInputLayoutLogin.error = getString(R.string.error_incorrect_email)
            }
        }

        binding.buttonLogin.setOnClickListener(View.OnClickListener {
            val login = binding.emailTextInputLogin.text.toString().trim()
            val password = binding.passwordTextInputEditTextLogin.text.toString().trim()
            var count = 0
            if (login.isNotEmpty() && password.isNotEmpty()) {
                while (true) {
                    if (login == viewModel.getUser(count).login &&
                        password == viewModel.getUser(count).password) {
                        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                        startActivity(intent)
                        break
                    } else {
                        count++
                        Toast.makeText(
                            this, getString(R.string.this_user_was_not_found),
                            Toast.LENGTH_SHORT
                        ).show()
                        break
                    }
                }
            } else {
                Toast.makeText(
                    this, R.string.toast_empty_fields,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

    binding.registerTextViewLogin.setOnClickListener(View.OnClickListener
    {
        val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
        startActivity(intent)
    })

    binding.forgotPasswordTextViewLogin.setOnClickListener(View.OnClickListener
    {
        val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
        startActivity(intent)
    })
}

companion object {
    fun getStartIntent(context: Context): Intent {
        return Intent(context, LoginActivity::class.java)
    }
}
}