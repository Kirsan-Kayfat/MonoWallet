package com.shuchenysh.monowallet

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shuchenysh.monowallet.data.UsersDatabase
import com.shuchenysh.monowallet.databinding.ActivityHomeBinding
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var balance = 0.0f
    private lateinit var database: UsersDatabase
    private lateinit var sPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater).also { setContentView(it.root) }
        val adapter = RecyclerViewAdapter()
        binding.detailRecyclerViewHome.adapter = adapter
        database = UsersDatabase.getInstance(this)
        sPref = getSharedPreferences("BALANCE", Context.MODE_PRIVATE)
        editor = sPref.edit()
        sPref.getFloat("balance", 0.0f)

        database.transactionDao().getTransactions().observe(this, androidx.lifecycle.Observer {
            adapter.transactionInfoList = it
        })
    }

    override fun onStart() {
        super.onStart()
        binding.textViewBalance.text = "$ $balance"
    }

    override fun onDestroy() {
        super.onDestroy()
        editor.putFloat("balance", balance).apply()
    }
}