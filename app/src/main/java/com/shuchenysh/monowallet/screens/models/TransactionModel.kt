package com.shuchenysh.monowallet.screens.models

import androidx.annotation.DrawableRes

data class TransactionModel(
    val money: String,
    val category: String,
    @DrawableRes val arrow: Int
)