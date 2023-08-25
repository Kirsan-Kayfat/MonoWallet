package com.shuchenysh.monowallet.screens.newtransaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.shuchenysh.monowallet.R
import com.shuchenysh.monowallet.Transaction
import com.shuchenysh.monowallet.data.TransactionViewModel
import com.shuchenysh.monowallet.databinding.FragmentNewTransactionBinding
import com.shuchenysh.monowallet.extension.isEmailInvalid

class NewTransactionFragment : Fragment() {

    private lateinit var binding: FragmentNewTransactionBinding
    private var transactions = mutableListOf<Transaction>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNewTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            addNewTransactionButton.setOnClickListener {
                val transaction = getTransaction()
                if (transaction.amount.isEmailInvalid()) return@setOnClickListener
                transactions.add(transaction)

                Toast.makeText(this@NewTransactionFragment.context, "Completed", Toast.LENGTH_SHORT).show()
                moneyNewTransactionEditText.text = null
            }

            amountNewTransactionEditText.doAfterTextChanged {
                amountNewTransactionTextInput.error = null
            }
        }
    }

    private fun getTransaction(): Transaction {
        with(binding) {
            val email = amountNewTransactionEditText.text.toString()
            val category = R.drawable.coffee
            val arrow = R.drawable.arrow_up
            val money = moneyNewTransactionEditText.text.toString().toInt()
            return Transaction(0, arrow, email, category, money)
        }
    }

    private fun isValidateEmailField(email: String): Boolean {
        return when {
            email.isEmpty() -> {
                binding.amountNewTransactionTextInput.error =
                    getString(R.string.the_field_cannot_be_empty)
                false
            }

            email.isEmailInvalid() -> {
                binding.amountNewTransactionTextInput.error = getString(R.string.email_is_invalid)
                false
            }

            else -> {
                binding.amountNewTransactionTextInput.error = null
                true
            }
        }
    }
}