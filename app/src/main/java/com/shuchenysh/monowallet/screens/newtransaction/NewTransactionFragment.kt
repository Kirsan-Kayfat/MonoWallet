package com.shuchenysh.monowallet.screens.newtransaction

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shuchenysh.monowallet.R
import com.shuchenysh.monowallet.RecyclerViewAdapter
import com.shuchenysh.monowallet.Transaction
import com.shuchenysh.monowallet.databinding.FragmentNewTransactionBinding
import com.shuchenysh.monowallet.extension.isEmailInvalid
import com.shuchenysh.monowallet.screens.home.HomeFragment

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
            if (email.isEmailInvalid() or email.isEmpty()) {
                isValidateEmailField(email)
                return@setOnClickListener
            }
            val category = R.drawable.coffee
            val arrow = R.drawable.arrow_up
            val money = binding.moneyNewTransactionEditText.text.toString().toInt()
            val transaction = Transaction(0, arrow, email, category, money)
            adapter.transactionInfoList.add(transaction)
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