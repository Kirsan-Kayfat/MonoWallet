package com.shuchenysh.monowallet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shuchenysh.monowallet.databinding.ActivityHomeBinding
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var balance = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        binding.textViewBalance.text = "$ $balance"
    }
}