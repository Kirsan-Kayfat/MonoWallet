package com.shuchenysh.monowallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var buttonOnBoarding: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        buttonOnBoarding = findViewById(R.id.button_onBoarding)

        buttonOnBoarding.setOnClickListener {
            val intent = LoginActivity.getStartIntent(this)
            startActivity(intent)
        }
    }
}