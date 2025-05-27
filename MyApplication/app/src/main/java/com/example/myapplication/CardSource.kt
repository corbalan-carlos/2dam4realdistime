package com.example.myapplication

interface CardSource {
    fun get () : Card
    fun push(pushable:List<Card>) : Boolean
}