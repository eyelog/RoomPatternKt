package ru.eyelog.roompatternkt

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class OneMoreMockTest{

    lateinit var users : List<User>

    @Mock
    lateinit var db: AppDataBase
    @Mock
    lateinit var userDao: UserDao

    @Before
    fun initDB(){
        // Initialize db
        MockitoAnnotations.initMocks(this)

        given(db.getUserDao()).willReturn(userDao)

    }

    @Test
    fun testModelInfo(){
        val user = User(
            0,
            "name",
            123
        )

//        BDDMockito.given(userDao.getOneData(ArgumentMatchers.anyString()))
//            .willReturn(userEntity)
    }

}