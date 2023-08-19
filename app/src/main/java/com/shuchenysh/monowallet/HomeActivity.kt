package com.shuchenysh.monowallet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.shuchenysh.monowallet.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController
    private var balance = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.fragment_home_container)

        with(binding) {
            bottomNavigationMenu.setupWithNavController(navController)

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