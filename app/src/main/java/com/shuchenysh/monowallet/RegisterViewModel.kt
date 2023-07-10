package com.shuchenysh.monowallet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shuchenysh.monowallet.data.UsersDatabase
import io.reactivex.rxjava3.disposables.CompositeDisposable

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val db = UsersDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    fun addUser(user: User) {
        db.usersDao().add(user)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}