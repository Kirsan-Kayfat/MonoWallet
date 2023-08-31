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
import com.shuchenysh.monowallet.extension.isEmailInvalid

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
                    "Completed"
                } else {
                    "Error"
                }
                Toast.makeText(this@NewTransactionFragment.context, message, Toast.LENGTH_SHORT).show()

                moneyNewTransactionEditText.text = null
            }

            amountNewTransactionEditText.doAfterTextChanged {
                amountFieldNewTransactionTextInput.error = null
            }
        }
    }

    private fun getTransaction(): TransactionModel {
        with(binding) {
            val money = moneyNewTransactionEditText.text.toString().trim()
            val category = categoryNewTransactionEditText.text.toString().trim()
            return TransactionModel(
                money = money,
                category = category
            )
        }
    }

    private fun isValidateEmailField(email: String): Boolean {
        return when {
            email.isEmpty() -> {
                binding.amountFieldNewTransactionTextInput.error =
                    getString(R.string.the_field_cannot_be_empty)
                false
            }

            email.isEmailInvalid() -> {
                binding.amountFieldNewTransactionTextInput.error = getString(R.string.email_is_invalid)
                false
            }

            else -> {
                binding.amountFieldNewTransactionTextInput.error = null
                true
            }
        }
    }
}