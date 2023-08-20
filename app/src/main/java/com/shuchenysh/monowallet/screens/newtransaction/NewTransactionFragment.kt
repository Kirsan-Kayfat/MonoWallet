package com.shuchenysh.monowallet.screens.newtransaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shuchenysh.monowallet.R
import com.shuchenysh.monowallet.RecyclerViewAdapter
import com.shuchenysh.monowallet.Transaction
import com.shuchenysh.monowallet.databinding.FragmentNewTransactionBinding

class NewTransactionFragment : Fragment() {

    private lateinit var binding: FragmentNewTransactionBinding
    private val adapter = RecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTransactionBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addNewTransactionButton.setOnClickListener {
            val email = binding.amountNewTransactionEditText.text.toString()
            val category = R.drawable.coffee
            val arrow = R.drawable.arrow_up
            val money = binding.moneyNewTransactionEditText.text.toString().toInt()
            val transaction = Transaction(0, arrow, email, category, money)
            adapter.transactionInfoList.add(transaction)
        }
    }
}