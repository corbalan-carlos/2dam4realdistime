package com.example.myapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import java.util.Stack

abstract class CardStack (){
    abstract val shwocoefficient: Float
    abstract val actualStack: ArrayList<Card>
    abstract fun getCards(): List<Card>
    abstract fun push(c: Card)
    abstract fun pop()
    abstract fun peek(): Card?
    @Composable
    abstract fun ShowCards()
    
}