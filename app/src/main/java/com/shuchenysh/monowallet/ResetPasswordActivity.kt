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
        binding = ActivityResetPasswordBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.buttonResetPassword.setOnClickListener(View.OnClickListener {
        val intent = Intent(this@ResetPasswordActivity, LoginActivity::class.java)
        startActivity(intent)
        })
    }
}