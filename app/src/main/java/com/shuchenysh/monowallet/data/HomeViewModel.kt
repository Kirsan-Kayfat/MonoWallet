package com.shuchenysh.monowallet.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shuchenysh.monowallet.Transaction
import io.reactivex.rxjava3.disposables.CompositeDisposable

class HomeViewModel(context: Context) : ViewModel() {

    private val db = UsersDatabase.getInstance(context)
    private val compositeDisposable = CompositeDisposable()

    fun getTransaction() = db.transactionDao().getTransactions()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}