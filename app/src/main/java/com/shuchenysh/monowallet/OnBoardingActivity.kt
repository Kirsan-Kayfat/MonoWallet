package com.shuchenysh.monowallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.shuchenysh.monowallet.databinding.ActivityOnboardingBinding

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.buttonOnBoarding.setOnClickListener {
            val intent = LoginActivity.getStartIntent(this)
            startActivity(intent)
        }
    }
}