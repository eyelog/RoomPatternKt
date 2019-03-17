package ru.eyelog.roompatternkt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userDao = AppUtil.dataBase!!.getUserDao()

        buttonPush.setOnClickListener {
            userDao.add(User(0, etText.text.toString(), etNumber.text.toString().toInt()))
        }

        buttonPull.setOnClickListener {
            var users = userDao.getAllData()
            var parsedUsers = ArrayList<String>()
            for (user in users) {
                parsedUsers.add("id = " + user.id + ", text = " + user.name + ", number = " + user.number)
            }
            listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, parsedUsers)
        }
    }
}
