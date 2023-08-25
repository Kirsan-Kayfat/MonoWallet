package com.shuchenysh.monowallet.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.shuchenysh.monowallet.Transaction
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TransactionViewModel(context: Context) : ViewModel() {

    private val db = UsersDatabase.getInstance(context)
    private val compositeDisposable = CompositeDisposable()

    fun addTransaction(transaction: Transaction) {
        val disposable = db.transactionDao().add(transaction).subscribeOn(Schedulers.io()).subscribe()
        compositeDisposable.add(disposable)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}