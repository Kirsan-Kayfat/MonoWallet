package com.shuchenysh.monowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.textfield.TextInputEditText

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var button_sendLink: Button
    private lateinit var imageView_arrowLeft: ImageView
    private lateinit var textInputEditTextEmail: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        initViews()
        button_sendLink.setOnClickListener(View.OnClickListener {
            val intent = Intent(
                this@ForgotPasswordActivity,
                ResetPasswordActivity::class.java
            )
            startActivity(intent)
            finish()
        })

        imageView_arrowLeft.setOnClickListener(View.OnClickListener {
            val intent = Intent(
                this@ForgotPasswordActivity,
                LoginActivity::class.java
            )
            startActivity(intent)
            finish()
        })
    }

    private fun initViews() {
        button_sendLink = findViewById(R.id.button_forgot_password)
        imageView_arrowLeft = findViewById(R.id.arrow_left_image_view_forgot_password)
        textInputEditTextEmail = findViewById(R.id.email_text_input_edit_text_forgot_password)
    }
}