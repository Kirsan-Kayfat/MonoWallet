package com.shuchenysh.monowallet

data class Transaction(
    val id: Int,
    val arrowImage: String,
    val money: String,
    val description: String,
    val categoryImage: String
)