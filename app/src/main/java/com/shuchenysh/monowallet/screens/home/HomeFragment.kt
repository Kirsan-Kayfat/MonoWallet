package com.shuchenysh.monowallet.screens.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shuchenysh.monowallet.TransactionHelper
import com.shuchenysh.monowallet.screens.transactionadapter.TransactionAdapter
import com.shuchenysh.monowallet.WalletsActivity
import com.shuchenysh.monowallet.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: TransactionAdapter
    private var balance = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TransactionAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            transactionsHomeList.adapter = adapter

            openWalletsHomeButton.setOnClickListener {
                val intent = Intent(this@HomeFragment.context, WalletsActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun setBalance(balance: String) {
        var balance = 0
        for (i in TransactionHelper.getTransactions()) {
            balance += i.money.toInt()

        }
    }
}