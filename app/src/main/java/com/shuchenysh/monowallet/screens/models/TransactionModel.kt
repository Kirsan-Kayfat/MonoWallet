package com.shuchenysh.monowallet.screens.models

import com.shuchenysh.monowallet.R

data class TransactionModel(
    val arrow: Int,
    val money: String,
    val category: String = R.string.default_category.toString()
)