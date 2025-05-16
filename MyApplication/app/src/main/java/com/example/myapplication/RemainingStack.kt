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

class RemainingStack(val actualStack: CircularLinkedList<Card>) {
     val shwocoefficient: Float = 0.0f
     var lastIndex = actualStack.size-1
     var index = 0
     var currentCard: Card?=null
     //Quitar de la lista
     fun get(): Card {
         currentCard?:throw OperationNotAllowedException()
         if (index==lastIndex) index--
         lastIndex--
         return actualStack.remove(index)
    }
    //Evento (one and done logic)
     fun peek() :Card? {
        if (currentCard==null) {
            index=0
            currentCard=actualStack.get(0)
            index++
            return currentCard
        } else if (index==actualStack.size){
            currentCard=null
            index++
            return currentCard
        } else {
            currentCard=actualStack.get(index++)
            return currentCard
        }
     }
    //Persistente(hold logic) (ocurre despues de peek)
    @Composable
     fun ShowCards(currentCard: Card?) {
        Box(Modifier.width(150.dp).height(400.dp) .background(Color(125, 255, 150, 255))){
                if (actualStack.isEmpty()||index==actualStack.size) {
                    Row (Modifier.padding(25.dp).align(Alignment.TopStart), horizontalArrangement = Arrangement.Center) {
                        Box(
                            Modifier
                                .width(100.dp).height(150.dp)
                                .background(Color(125, 255, 150, 255))
                        ) {
                            Box(
                                Modifier.padding(3.dp).fillMaxSize().clip(RoundedCornerShape(5.dp,))
                            )
                            {
                                Box(Modifier.background(Color.White).fillMaxSize())
                            }
                        }
                    }

                } else {
                    Row (Modifier.padding(25.dp).align(Alignment.TopStart), horizontalArrangement = Arrangement.Center) {
                        val cardBottomUp=actualStack.get(index+1)
                        cardBottomUp.show=false
                        cardBottomUp.ShowCard()
                    }
                }
                if (actualStack.isEmpty()||currentCard==null) {
                    Row (Modifier.padding(25.dp).align(Alignment.BottomCenter), horizontalArrangement = Arrangement.Center) {
                        Box(
                            Modifier
                                .width(100.dp).height(150.dp)
                                .background(Color(125, 255, 150, 255))
                        ) {
                            Box(
                                Modifier.padding(3.dp).fillMaxSize().clip(RoundedCornerShape(5.dp,))
                            )
                            {
                                Box(Modifier.background(Color.White).fillMaxSize())
                            }
                        }
                    }
                } else {
                    Row (Modifier.padding(25.dp).align(Alignment.BottomCenter), horizontalArrangement = Arrangement.Center) {
                        currentCard!!.show=true
                        currentCard!!.ShowCard()
                    }
                }
        }
    }
}
@Composable
@Preview
fun hola() {
    val b =remember {val list= CircularLinkedList<Card>()
        list.put(Card(0,1,true))
        list.put(Card(3,12,true))
        list.put(Card(1,4,true))
        list.put(Card(2,2,true))
        list.put(Card(1,6,true))
        list.put(Card(0,9,true))
        list.put(Card(0,2,true)); RemainingStack(list) }
    var state by remember { mutableStateOf(b.currentCard) }
    adios(b,state, {state = it})
}
@Composable
fun adios(circular: RemainingStack, state: Card?, onValueChange: (Card?)-> Unit) {
    circular.ShowCards(state)
    Box (Modifier.width(100.dp).height(100.dp), contentAlignment = Alignment.TopStart){
        Button( onClick =
            {
                 onValueChange(circular.peek())
            })
        {
            Text(text = "click me!!!")
        }
    }
}
