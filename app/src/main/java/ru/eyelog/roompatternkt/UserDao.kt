package ru.eyelog.roompatternkt

import android.arch.persistence.room.*

@Dao
interface UserDao {

    @Insert
    fun add(user: User)

    @Insert
    fun addAll(vararg users:User)

    @Query("SELECT * FROM user")
    fun getAllData():List<User>

    @Query("SELECT * FROM user WHERE id = :userId")
    fun getOneData(userId:Int):User

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("DELETE FROM user")
    fun deleteAll()
}