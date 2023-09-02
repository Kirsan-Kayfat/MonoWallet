package com.shuchenysh.monowallet.screens.models

data class TransactionModel(
    val arrow: Int,
    val money: String,
    val category: String = "Without category"
)