package com.shuchenysh.monowallet.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shuchenysh.monowallet.User
@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun add(user: User)

    @Query("SELECT * FROM users")
    fun getUsers(): List<User>

    @Query("SELECT * FROM users WHERE id = :userID")
    fun getUser(userID: Int): User

}