package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class PlayStack (val cards: ArrayList<Card>): CardStack(), CardSource{
    override val showcoefficient: Float = 0.05f;
    override val actualStack: ArrayList<Card> = cards
    override fun getCards(): List<Card> {
        return actualStack.toList();
    }
    override fun push(c: Card): Boolean {
        if (actualStack.isEmpty() &&  c.value==12) {
            actualStack.add(c)
            a.add(c)
            return true
        }
        val topCard=actualStack[actualStack.size-1]
        if ( topCard.suit xor c.suit and 1==1 &&topCard.value-c.value==1) {
            actualStack.add(c)
            a.add(c)
            return true
        }
        return false
    }

    override fun pop() :Card {
        a.removeAt(a.size-1)
        return actualStack.removeAt(actualStack.size - 1)
    }

    override fun peek(): Card? {
        if (actualStack.isEmpty()) return null
        return  actualStack[actualStack.size-1]
    }
    val a = run {
        val b = mutableStateListOf<Card>()
        b.addAll(cards)
        b
    }
    @Composable
    fun ShowCards(bottomClickable: ()->Unit ,updater : (Card?)->Unit,clickable: ()->Unit) {
        val stack = remember { a }
        key (stack.size) {
            if (stack.size > 0) {
                Box(
                    Modifier.width(66.dp)
                        .height((100 + ((actualStack.size - 1) * 100 * showcoefficient)).dp)
                )
                {
                    var a = 0f
                    stack.forEach {
                        Row(
                            Modifier.fillMaxWidth().padding(top = a.dp),
                            Arrangement.spacedBy((-100 * showcoefficient).dp)
                        ) {
                            stack.last().show = true
                            it.ShowCard(updater, clickable)
                        }
                        a += (100 * showcoefficient)
                    }
                }
            } else {
                Box(
                    Modifier
                        .width(66.dp).height(100.dp)
                        .background(Color(125, 255, 150, 255))
                        .clickable{bottomClickable.invoke()}
                ) {
                    Box(Modifier.padding(3.dp).fillMaxSize().clip(RoundedCornerShape(5.dp,)))
                    {
                        Box(Modifier.background(Color.White).fillMaxSize())
                    }
                }
            }
        }
    }
    @Composable
    override fun ShowCards(updater : (Card?)->Unit) {
       /* var clickable= {}
        val stack = remember {
          a
        }
        key (stack.size) {
            if (stack.size > 0) {
                Box(
                    Modifier.width(66.dp)
                        .height((100 + ((actualStack.size - 1) * 100 * showcoefficient)).dp)
                )
                {
                    var a = 0f
                    stack.forEach {
                        Row(
                            Modifier.fillMaxWidth().padding(top = a.dp),
                            Arrangement.spacedBy((-100 * showcoefficient).dp)
                        ) {
                            it.ShowCard(updater, null)
                        }
                        a += (100 * showcoefficient)
                    }
                }
            } else {
                Box(
                    Modifier
                        .width(66.dp).height(100.dp)
                        .background(Color(125, 255, 150, 255))
                ) {
                    Box(Modifier.padding(3.dp).fillMaxSize().clip(RoundedCornerShape(5.dp,)))
                    {
                        Box(Modifier.background(Color.White).fillMaxSize())
                    }
                }
            }
        }*/
    }

    override fun get(): Card {
       return this.pop()
    }

    override fun push(pushable: List<Card>):Boolean {
        var returnable: Boolean =false
        pushable.forEach{
            returnable=this.push(it)
        }
        return returnable
    }
}
@Composable
@Preview
fun A() {
   val b = PlayStack(
       arrayListOf(
              Card(0,1,false),
              Card(3,12,false),
               Card(1,4,true)
   ))
    b.ShowCards{ Log.i("why it dont work", "me not know")}
    b.push(Card(0,3,true))
}