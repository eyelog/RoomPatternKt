package ru.eyelog.roompatternkt

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Before
import android.arch.persistence.room.Room
import android.util.Log
import org.junit.After

@RunWith(AndroidJUnit4::class)
class FullDBTest {

    val TAG : String = "Logcat"

    private var db: AppDataBase? = null
    private var userDao: UserDao? = null

    lateinit var users : List<User>

    @Before
    @Throws(Exception::class)
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getContext(),
            AppDataBase::class.java
        )
            .build()
        userDao = db!!.getUserDao()

    }

    @Test
    @Throws(Exception::class)
    fun addSomeData() {
        userDao!!.add(User(0, "One", 1))
        userDao!!.add(User(0, "Two", 2))
        userDao!!.add(User(0, "Three", 3))
    }

    @Test
    @Throws(Exception::class)
    fun readSomeData(){
        users = AppUtil.dataBase?.getUserDao()?.getAllData()!!
        users.forEach{
            Log.i(TAG, it.name)
        }
    }

    @Test
    @Throws(Exception::class)
    fun updateSomeData(){
        users = AppUtil.dataBase?.getUserDao()?.getAllData()!!
        users.forEach{
            it.name = it.name + "updated"
            userDao?.update(it)
        }
    }

    @Test
    @Throws(Exception::class)
    fun readUpdatedData(){
        users = AppUtil.dataBase?.getUserDao()?.getAllData()!!
        users.forEach{
            Log.i(TAG, it.name)
        }
    }

    @Test
    @Throws(Exception::class)
    fun deleteAllData(){
        userDao?.deleteAll()
    }

    @After
    @Throws(Exception::class)
    fun closeDb() {
        db!!.close()
    }
}
