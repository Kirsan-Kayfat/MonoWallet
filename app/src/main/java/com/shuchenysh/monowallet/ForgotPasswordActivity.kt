package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.textfield.TextInputEditText
import com.shuchenysh.monowallet.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.buttonForgotPassword.setOnClickListener(View.OnClickListener {
            val intent = Intent(
                this@ForgotPasswordActivity,
                ResetPasswordActivity::class.java
            )
            startActivity(intent)
            finish()
        })

        binding.arrowLeftImageViewForgotPassword.setOnClickListener(View.OnClickListener {
            val intent = Intent(
                this@ForgotPasswordActivity,
                LoginActivity::class.java
            )
            startActivity(intent)
            finish()
        })
    }
}