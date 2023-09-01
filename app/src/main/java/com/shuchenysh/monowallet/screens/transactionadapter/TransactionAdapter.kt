package com.shuchenysh.monowallet.screens.transactionadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.shuchenysh.monowallet.TransactionHelper
import com.shuchenysh.monowallet.databinding.ItemTransactionBinding

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTransactionBinding.inflate(inflater, parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = TransactionHelper.getTransactions()[position]
        with(holder.binding) {
            arrowItemImage.setImageResource(transaction.arrow)
            moneyItemText.text = transaction.money
            descriptionItemText.text = transaction.category
        }
    }

    override fun getItemCount() = TransactionHelper.getTransactions().size

    class TransactionViewHolder(val binding: ItemTransactionBinding) : ViewHolder(binding.root)
}