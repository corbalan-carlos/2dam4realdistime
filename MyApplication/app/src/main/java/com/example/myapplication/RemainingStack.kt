package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier.*

class RemainingStack(val actualStack: ArrayList<Card>): CardSource {
     var lastIndex = -1
     var index = 0
     //Quitar de la lista
     override fun get(): Card {
         val returnable= actualStack.removeAt(index)
         if (lastIndex==index) index--
         lastIndex=actualStack.size-1
         return returnable
    }

    override fun push(pushable: List<Card>):Boolean {
        return false
    }

    fun get(index: Int): Card {
        val returnable= actualStack.removeAt(index)
       if (lastIndex==index) this.index--
        lastIndex=actualStack.size-1
        return returnable
    }
     fun peek() :Card {
        if (index>lastIndex) index=0
        return actualStack.get(index++)
     }
     init {
         this.lastIndex=actualStack.size-1
    }
    //fun deal (state:Card) = {if (!Card.cardAlreadySelected) state = this@RemainingStack.peek()}
    @Composable
    fun ShowCards(index: Int,onClick: (Int)-> Unit,updater: (Card) -> Unit) {
        val stack = remember { actualStack }
        val empty by remember { mutableStateOf(actualStack.isEmpty()) }
        Box(
                Modifier
                    .width(100.dp).height(225.dp).background(Color(125, 255, 150, 255))
            ) {
                Button( onClick = {
                    onClick.invoke(index);
                    stack.add(stack.removeAt(0))
                }
                    , modifier = Modifier.align(Alignment.TopCenter)) {
                    Text("Deal")
                }
                if (empty ) {
                    Row(
                        Modifier.align(Alignment.BottomCenter).padding(8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            Modifier
                                .width(66.dp).height(100.dp)
                                .background(Color(125, 255, 150, 255))
                        ) {
                            Box(
                                Modifier.padding(1.dp).fillMaxSize()
                                    .clip(RoundedCornerShape(1.dp,))
                            )
                            {
                                Box(Modifier.background(Color.White).fillMaxSize())
                            }
                        }
                    }
                } else {
                    Row(
                        Modifier.padding(8.dp).align(Alignment.BottomCenter),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box {
                            stack.reversed().forEach{
                                it.show = true
                                it.ShowCard(updater, null)
                            }
                        }
                    }
                }
            }

    }
}




@Composable
@Preview
fun Hola() {
    val b = remember { mutableListOf<Card>()}
    b.add((Card(0,2,true)))
    b.add(Card(1,2,true))
    b.add(Card(2,2,true))
    b.add(Card(3,2,true))
    val c by remember { mutableStateOf(RemainingStack(ArrayList(b))) }
    var int by remember { mutableIntStateOf(0) }
    c.ShowCards(int,{if (int == c.actualStack.lastIndex) int =0 else int++} ) {}
    Box(modifier = Modifier.fillMaxSize(),Alignment.Center) {
        Button(onClick = { c.get();int-- }) {
            Text(text = "b")
        }
    }
    //adios(b,state) {state=it }
}

