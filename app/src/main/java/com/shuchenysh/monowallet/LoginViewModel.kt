package com.shuchenysh.monowallet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shuchenysh.monowallet.data.UsersDatabase
import io.reactivex.rxjava3.disposables.CompositeDisposable

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val db = UsersDatabase.getInstance(application)

    fun getUser(userID: Int): User = db.usersDao().getUser(userID)

}