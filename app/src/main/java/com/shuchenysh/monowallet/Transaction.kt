package com.shuchenysh.monowallet

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val arrow: Int,
    val amount: String,
    val categoryImage: Int,
    val money: Int
)