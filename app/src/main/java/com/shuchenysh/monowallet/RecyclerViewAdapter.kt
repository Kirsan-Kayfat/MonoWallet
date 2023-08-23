package com.shuchenysh.monowallet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.shuchenysh.monowallet.databinding.ItemTransactionBinding

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.TransactionViewHolder>() {
    var transactions: List<Transaction> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding)
    }

    override fun getItemCount() = transactions.size

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]
        with(holder.binding) {
            arrowItemImage.setImageResource(transaction.arrow)
            moneyItemText.text = transaction.money.toString()
            categoryItemImage.setImageResource(transaction.category)
            descriptionItemText.text = transaction.amount
        }
    }

    class TransactionViewHolder(val binding: ItemTransactionBinding) : ViewHolder(binding.root)
}