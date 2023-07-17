package com.shuchenysh.monowallet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.shuchenysh.monowallet.data.UsersDatabase
import io.reactivex.rxjava3.disposables.CompositeDisposable

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val db = UsersDatabase.getInstance(application)

    fun addUser(user: User) {
        db.usersDao().add(user)
    }

}