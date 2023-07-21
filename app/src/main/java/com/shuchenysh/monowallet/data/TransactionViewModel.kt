package com.shuchenysh.monowallet.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shuchenysh.monowallet.Transaction
import com.shuchenysh.monowallet.User
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TransactionViewModel(application: Application) : AndroidViewModel(application) {

    private val db = UsersDatabase.getInstance(application)
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