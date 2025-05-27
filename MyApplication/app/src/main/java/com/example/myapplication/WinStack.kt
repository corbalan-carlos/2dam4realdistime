package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlin.collections.ArrayList

class WinStack : CardStack() {
    override val showcoefficient = 0.0f
    override val actualStack: ArrayList<Card> = ArrayList<Card>()
    var suit: Int = -1
    override fun getCards(): List<Card> {
        return actualStack.toList()
    }
    companion object {
        val coordMap = mutableMapOf<Offset,CardStack>()
    }
    override fun push(c: Card) :Boolean{
        val result = peek()
        if (result == null && c.value==0) {
            suit=c.suit
            actualStack.add(c)
        } else if (c.suit==suit && c.value-1==peek()!!.value) {
            actualStack.add(c)
        } else return false
        return true

    }

    override fun pop() : Card{
        throw OperationNotAllowedException();
    }
    override fun  peek(): Card? {
        if (actualStack.isEmpty()) return null
        return actualStack[actualStack.size-1]
    }

    @Composable
    override fun ShowCards(updater: (Card?) -> Unit) {
        TODO("Not yet implemented")
    }

    //I hate this
    @Composable
    fun ShowCards(clickable: ()->Unit, updater: (Card?) -> Unit) {
        val topOfStack=peek()?:(

                    Box(
                        Modifier
                            .width(66.dp).height(100.dp)
                            .background(Color(125, 255, 150, 255))
                            .clickable { clickable.invoke() }
                    ) {
                        Box(Modifier.padding(3.dp).fillMaxSize().clip(RoundedCornerShape(2.dp,)))
                        {
                            Box(Modifier.background(Color.White).fillMaxSize())
                        }
                    }

        )
        Box(Modifier
            .width(66.dp).height(100.dp)) {
            if (topOfStack is Card) {
                topOfStack.ShowCard(updater,null)
            } else {
                topOfStack
            }
        }
    }

}
/*
@Preview
@Composable
fun prueba() {
    val a = WinStack()
    try {
    } catch (e: OperationNotAllowedException) {
      Text("ooooopsies")
      return
    }
    a.ShowCards{Unit}
}*/