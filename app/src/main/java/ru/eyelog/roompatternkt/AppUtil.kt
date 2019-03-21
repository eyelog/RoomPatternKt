package ru.eyelog.roompatternkt

import android.annotation.SuppressLint
import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import kotlin.coroutines.coroutineContext

class AppUtil : Application() {

    companion object {
        var dataBase: AppDataBase? = null
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        AppUtil.dataBase = Room.databaseBuilder(this, AppDataBase::class.java, "userbase")
            .allowMainThreadQueries()
            .build()

        AppUtil.context = applicationContext
    }
}