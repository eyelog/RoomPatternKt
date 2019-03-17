package ru.eyelog.roompatternkt

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun getUserDao() : UserDao
}