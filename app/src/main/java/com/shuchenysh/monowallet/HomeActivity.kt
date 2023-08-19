package com.shuchenysh.monowallet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shuchenysh.monowallet.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var balance = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            openWalletsHomeButton.setOnClickListener {
                val intent = Intent(this@HomeActivity, WalletsActivity::class.java)
                startActivity(intent)
            }

            val adapter = RecyclerViewAdapter()
            transactionsHomeList.adapter = adapter


        }
    }

    override fun onStart() {
        super.onStart()
        binding.balanceHomeText.text = "$ $balance"
    }
}