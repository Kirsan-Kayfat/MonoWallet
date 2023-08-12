package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.shuchenysh.monowallet.databinding.ActivityCheckEmailBinding

class CheckEmailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheckEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckEmailBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.openEmailAppCheckEmailButton.setOnClickListener {
            val intent = Intent(this@CheckEmailActivity, ResetPasswordActivity::class.java)
            startActivity(intent)
        }

        binding.backCheckEmailImage.setOnClickListener {
            finish()
        }
    }
}