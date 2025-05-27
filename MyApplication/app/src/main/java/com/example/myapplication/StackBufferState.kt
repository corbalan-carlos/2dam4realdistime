package com.example.myapplication

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

class StackBuffer(passedStack: MutableList<Card>): ViewModel(){
    val showcoefficient: Float= 0.03f
    val actualStack: MutableList<Card> =  passedStack
    var onUpdate = mutableIntStateOf(0)
    fun getCards(): List<Card> {
        return  actualStack.toList()
    }
    fun isEmpty () :Boolean {
        return actualStack.isEmpty()
    }
    fun push(a:List<Card>) {
        a.reversed().forEach {
            actualStack.add(it)
        }
    }
    private fun updateUI() {
        onUpdate.intValue = (0..1_000_000).random()
    }
    fun pop () {
        actualStack.removeAll{true}
    }
    fun update(){
        updateUI()
    }
}