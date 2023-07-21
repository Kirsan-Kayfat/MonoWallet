package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.shuchenysh.monowallet.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater).also { setContentView(it.root) }
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding.loginTextViewRegister.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        })

        binding.emailTextInputEditTextRegister.doOnTextChanged { text, start, before, count ->
            if (text.toString().endsWith("@mail.ru") ||
                text.toString().endsWith("@gmail.com") ||
                text.toString().endsWith("@bk.ru") ||
                text.toString().endsWith("@yandex.ru")
            ) {
                binding.emailTextInputLayoutRegister.error = null
            } else {
                binding.emailTextInputLayoutRegister.error = getString(R.string.error_incorrect_email)
            }
        }

        binding.enterButtonRegister.setOnClickListener(View.OnClickListener {
            val login = binding.emailTextInputEditTextRegister.text.toString().trim()
            val password = binding.passwordTextInputEditTextRegister.text.toString().trim()
            if (login.isNotEmpty() && password.isNotEmpty()) {
                val user = User(0, login, password)
                viewModel.addUser(user)
                val intent = Intent(this@RegisterActivity, CheckEmailActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    R.string.toast_empty_fields,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}