package com.shuchenysh.monowallet.data

import androidx.room.Dao
import androidx.room.Insert
import com.shuchenysh.monowallet.User

@Dao
interface UsersDao {

    @Insert
    fun add(user: User)

}