package com.shuchenysh.monowallet

import com.shuchenysh.monowallet.screens.models.TransactionModel


object TransactionHelper {

    private val transactions = mutableListOf<TransactionModel>()

    fun addTransaction(transaction: TransactionModel) = transactions.add(transaction)

    fun getTransactions() = transactions
}

