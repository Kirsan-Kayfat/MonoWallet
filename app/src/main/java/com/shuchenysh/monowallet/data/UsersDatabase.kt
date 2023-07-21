package com.shuchenysh.monowallet.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shuchenysh.monowallet.Transaction
import com.shuchenysh.monowallet.User

@Database(entities = [User::class, Transaction::class], version = 1)
abstract class UsersDatabase : RoomDatabase() {
    companion object {
        private var db: UsersDatabase? = null
        private const val DB_NAME = "user.db"
        private val LOCK = Any()
        fun getInstance(context: Context): UsersDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(context, UsersDatabase::class.java, DB_NAME).build()
                db = instance
                return instance
            }
        }
    }
    abstract fun usersDao(): UsersDao
    abstract fun transactionDao(): TransactionDao
}