package com.shuchenysh.monowallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.shuchenysh.monowallet.data.TransactionViewModel
import com.shuchenysh.monowallet.databinding.ActivityTransactionBinding

class NewTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAddTransaction.setOnClickListener(View.OnClickListener {
            val email: String = binding.amountTextInputNewTransaction.text.toString()
            val category = R.drawable.coffee
            val arrow = R.drawable.arrow_up
            val money = binding.moneyTextInputNewTransaction.text.toString().toInt()
            val transaction = Transaction(0, arrow, email, category, money)
            finish()
        })

    }
}