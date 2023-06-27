package com.shuchenysh.monowallet.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null
        private const val DB_NAME = "users.db"

        fun getDatabase(context: Context): UserDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
           synchronized(this){
               val instance = Room.databaseBuilder(
                   context.applicationContext,
                   UserDatabase::class.java,
                   DB_NAME
               ).build()
               INSTANCE = instance
               return instance
           }
        }

    }

}