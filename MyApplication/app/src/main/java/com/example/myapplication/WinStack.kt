package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.collections.ArrayList

class WinStack : CardStack() {
    override val shwocoefficient = 0.0f
    override val actualStack: ArrayList<Card> = ArrayList<Card>()
    var suit: Int = -1
    override fun getCards(): List<Card> {
        return actualStack.toList()
    }

    override fun push(c: Card) {
        val result = peek()
        if (result == null && c.value==0) {
            suit=c.suit
            actualStack.add(c)
        } else if (c.suit==suit && c.value-1==peek()!!.value) {
            actualStack.add(c)
        } else throw OperationNotAllowedException()

    }

    override fun pop() {
        throw OperationNotAllowedException();
    }
    override fun  peek(): Card? {
        if (actualStack.isEmpty()) return null
        return actualStack.get(actualStack.size-1)
    }
    //I hate this

    @Composable
    override fun ShowCards() {
        val topOfStack=peek()?:(

                    Box(
                        Modifier
                            .width(100.dp).height(150.dp)
                            .background(Color(125, 255, 150, 255))
                    ) {
                        Box(Modifier.padding(3.dp).fillMaxSize().clip(RoundedCornerShape(5.dp,)))
                        {
                            Box(Modifier.background(Color.White).fillMaxSize())
                        }
                    }

        )
        Box(Modifier.width(100.dp).height(150.dp)) {
            if (topOfStack is Card) {
                topOfStack.ShowCard()
            } else {
                topOfStack
            }
        }
    }
}
//@Preview
//@Composable
/*fun prueba() {
    val a = WinStack()
    try {
        a.push(Card(value = 0, suit = 0, show = true))
        a.push(Card(value = 1, suit = 0, show = true))
        a.push(Card(value = 10, suit = 2, show = true))
    } catch (e: OperationNotAllowedException) {
        Text("ooooopsies")
      return
    }
    a.ShowCards()
}*/

