package com.shuchenysh.monowallet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.TransactionViewHolder>() {
    var transactionInfoList = listOf<Transaction>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaction, parent, false)
        return TransactionViewHolder(view)
    }

    override fun getItemCount() = transactionInfoList.size

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactionInfoList[position]
        val money = "$ " + transaction.money
        with(holder) {

        }
    }

    inner class TransactionViewHolder(itemView: View) : ViewHolder(itemView) {
        val imageViewArrow: ImageView = itemView.findViewById(R.id.image_view_item)
        val textViewMoney: TextView = itemView.findViewById(R.id.money_text_view_item)
        val textViewDescription: TextView = itemView.findViewById(R.id.description_text_view_item)
        val imageViewCategory: ImageView = itemView.findViewById(R.id.category_image_view_item)
    }
}