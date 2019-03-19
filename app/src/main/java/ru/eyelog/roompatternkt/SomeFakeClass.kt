package ru.eyelog.roompatternkt

import android.content.Context

class SomeFakeClass constructor(context:Context){

    val context = context
    lateinit var text : String

    fun getSomeText() :String{

        text = context.getString(R.string.app_name)

        return text
    }
}