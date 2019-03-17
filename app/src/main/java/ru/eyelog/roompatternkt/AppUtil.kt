package ru.eyelog.roompatternkt

import android.app.Application
import android.arch.persistence.room.Room

class AppUtil : Application() {

    companion object {
        var dataBase: AppDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        AppUtil.dataBase = Room.databaseBuilder(this, AppDataBase::class.java, "userbase")
            .allowMainThreadQueries()
            .build()
    }
}