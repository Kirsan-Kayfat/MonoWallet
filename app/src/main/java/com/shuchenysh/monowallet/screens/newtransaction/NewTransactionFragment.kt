package com.shuchenysh.monowallet.screens.newtransaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.shuchenysh.monowallet.R
import com.shuchenysh.monowallet.TransactionHelper
import com.shuchenysh.monowallet.screens.models.TransactionModel
import com.shuchenysh.monowallet.databinding.FragmentNewTransactionBinding

class NewTransactionFragment : Fragment() {

    private lateinit var binding: FragmentNewTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNewTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            addNewTransactionButton.setOnClickListener {
                val transaction = getTransaction()
                val isTransactionAdded = TransactionHelper.addTransaction(transaction)
                val message = if (isTransactionAdded) {
                    getString(R.string.completed)
                } else {
                    getString(R.string.error)
                }
                Toast.makeText(this@NewTransactionFragment.context, message, Toast.LENGTH_SHORT).show()
                moneyNewTransactionEditText.text = null
            }

            amountNewTransactionEditText.doAfterTextChanged {
                amountFieldNewTransactionTextInput.error = null
            }

            categoryNewTransactionEditText.doAfterTextChanged {
                categoryFieldNewTransactionTextInput.error = null
            }
        }
    }

    private fun getTransaction(): TransactionModel {
        with(binding) {
            val money = moneyNewTransactionEditText.text.toString().trim()
            val arrow = if (money.toInt() < 0) {
                R.drawable.arrow_up
            } else {
                R.drawable.arrow_down
            }

            val category = categoryNewTransactionEditText.text.toString().trim()

            return if (category.isNotEmpty()) {
                TransactionModel(
                    arrow = arrow,
                    money = "$ $money",
                    category = category
                )
            } else {
                TransactionModel(
                    arrow = arrow,
                    money = "$ $money"
                )
            }
        }
    }
}