package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.shuchenysh.monowallet.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.loginTextViewRegister.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        })

        binding.enterButtonRegister.setOnClickListener(View.OnClickListener {
            val login = binding.emailTextInputEditTextRegister.text.toString().trim()
            val password = binding.passwordTextInputEditTextRegister.text.toString().trim()
            if (login.isNotEmpty() && password.isNotEmpty()) {
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