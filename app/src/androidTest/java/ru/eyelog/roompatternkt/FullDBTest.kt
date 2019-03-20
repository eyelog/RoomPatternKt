package ru.eyelog.roompatternkt

import android.app.Application
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Before
import android.arch.persistence.room.Room
import org.junit.After
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class FullDBTest {

    val TAG : String = "Logcat: "

    private var db: AppDataBase? = null
    private var userDao: UserDao? = null

    lateinit var users : List<User>

    @Before
    @Throws(Exception::class)
    fun createDb() {

        db = Room.inMemoryDatabaseBuilder(
            AppUtil.context!!.applicationContext,
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

        users = AppUtil.dataBase?.getUserDao()?.getAllData()!!
        assertNotEquals(0, users.size)

        println(TAG + users.size)

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
            println(TAG + it.name)
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
