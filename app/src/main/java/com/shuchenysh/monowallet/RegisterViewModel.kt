package com.shuchenysh.monowallet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.shuchenysh.monowallet.data.UsersDatabase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val db = UsersDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    fun addUser(user: User) {
        val disposable = db.usersDao().add(user).subscribeOn(Schedulers.io()).subscribe()
        compositeDisposable.add(disposable)
    }
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}