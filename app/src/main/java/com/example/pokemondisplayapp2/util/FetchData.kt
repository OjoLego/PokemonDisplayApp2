package com.example.pokemondisplayapp2.util

object FetchData {

    fun getPageOffset(url: String): Int{
        return url.substring(41..url.lastIndex).takeWhile { it != '&' }.toInt()
    }

    fun getId(url:String):String{
        return url.substring(34 until url.lastIndex)
    }
}