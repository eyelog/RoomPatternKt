package ru.eyelog.roompatternkt

import android.util.Log
import org.junit.Test

import org.junit.Before
import ru.eyelog.roompatternkt.AppUtil.Companion.dataBase

class ExampleUnitTest {

    val TAG : String = "Logcat"

    @Before
    fun createBD(){
        dataBase?.getUserDao()?.add(User(0, "One", 1))
        dataBase?.getUserDao()?.add(User(0, "Two", 2))
        dataBase?.getUserDao()?.add(User(0, "Three", 3))
    }

    @Test
    fun addition_isCorrect() {
        val users : List<User> = dataBase?.getUserDao()?.getAllData()!!
        users.forEach{
            Log.i(TAG, it.name)
        }
    }
}
