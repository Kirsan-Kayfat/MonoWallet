package com.shuchenysh.monowallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shuchenysh.monowallet.databinding.ActivityTransactionBinding

class NewTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionBinding
    private val adapter = RecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonAddTransaction.setOnClickListener {
                val email: String = amountTextInputNewTransaction.text.toString()
                val category = R.drawable.coffee
                val arrow = R.drawable.arrow_up
                val money = moneyTextInputNewTransaction.text.toString().toInt()
                val transaction = Transaction(0, arrow, email, category, money)
                adapter.transactionInfoList.add(transaction)
                finish()
            }
        }
    }
}