package com.shuchenysh.monowallet.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shuchenysh.monowallet.Transaction
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun add(transaction: Transaction) : Completable

    @Query("SELECT * FROM transactions")
    fun getTransactions(): LiveData<List<Transaction>>

}