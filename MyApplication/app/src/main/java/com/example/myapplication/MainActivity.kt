package com.example.myapplication

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_USER
        enableEdgeToEdge()
        setContent {
            MainView()
        }
    }
    val playStacks = mutableListOf<PlayStack>()
    var remainingStack : RemainingStack
    @Composable
    fun MainView() {
        val selectedStack = remember { mutableStateListOf<Card>() }
        val currentSelectedCard by produceState(StackBuffer(selectedStack)) {
        }
        val remainingStack by remember { mutableStateOf(remainingStack )}
        var cardSource by remember { mutableStateOf<CardSource?>(null) }
        val winStacks = remember { listOf( WinStack(), WinStack(), WinStack(), WinStack()) }
        var WHYDOESTHISWORKDAWG = remember { (false ) }
        var int by remember { mutableIntStateOf(0) }
        Box( Modifier.fillMaxSize().background(Color(125, 255, 150, 255))) {
            Box(Modifier.padding(horizontal = 45.dp, vertical = 30.dp).fillMaxSize()) {
                Row (horizontalArrangement = Arrangement.SpaceEvenly){
                    Column(Modifier.padding(end = 30.dp)) {
                        remainingStack.ShowCards(int,{if (int == remainingStack.actualStack.lastIndex) int =0 else int++}) {
                            if (currentSelectedCard.isEmpty()) {
                                currentSelectedCard.push(mutableListOf(it))
                                cardSource = remainingStack
                            }
                        }
                    }
                        playStacks.forEach {
                            Column(Modifier.padding(6.dp)) {
                                it.ShowCards(
                                    {
                                        it.push(currentSelectedCard.getCards())
                                        val aS = (cardSource as PlayStack)
                                        for (i in currentSelectedCard.getCards()) aS.pop()
                                        aS.actualStack.getOrNull(aS.actualStack.size-1)?.show=true
                                        aS.a.getOrNull(aS.a.size-1)?.show=true
                                        currentSelectedCard.pop()
                                        Card.cardAlreadySelected = false
                                    },
                                    { itit ->
                                        if (currentSelectedCard.isEmpty()) {
                                            currentSelectedCard.push(
                                                it.getCards().takeLastWhile{ ititit ->
                                                    return@takeLastWhile ititit!=itit && ititit.show
                                                }.reversed().plus(itit!!)
                                            )

                                            cardSource = it
                                        }
                                    }
                                ) {
                                    if (Card.cardAlreadySelected) {
                                        if (it.push(currentSelectedCard.getCards())) {
                                            if (cardSource is RemainingStack) {
                                                (cardSource as RemainingStack).get()
                                                int--
                                                WHYDOESTHISWORKDAWG=true
                                            } else {
                                                val aS = (cardSource as PlayStack)
                                                for (i in currentSelectedCard.getCards()) aS.pop()
                                                aS.actualStack.getOrNull(aS.actualStack.size-1)?.show=true
                                                aS.a.getOrNull(aS.a.size-1)?.show=true
                                                WHYDOESTHISWORKDAWG=true
                                            }
                                            currentSelectedCard.pop()
                                            Card.cardAlreadySelected = false
                                        }
                                    }
                                }
                            }
                        }

                        }
                        Row(
                            Modifier.align(Alignment.BottomCenter),
                            Arrangement.Absolute.SpaceAround
                        ) {
                            winStacks.forEach {
                                Box {
                                    it.ShowCards({
                                        if (Card.cardAlreadySelected && currentSelectedCard.getCards().size == 1) {
                                            if (it.push(currentSelectedCard.getCards()[0])) {
                                                if (cardSource is RemainingStack) {
                                                    (cardSource as RemainingStack).get()
                                                    int--
                                                    WHYDOESTHISWORKDAWG = true
                                                } else {
                                                    val aS = (cardSource as PlayStack)
                                                    for (i in currentSelectedCard.getCards()) aS.pop()
                                                    aS.actualStack.getOrNull(aS.actualStack.size - 1)?.show =
                                                        true
                                                    aS.a.getOrNull(aS.a.size - 1)?.show = true
                                                    WHYDOESTHISWORKDAWG = true
                                                }
                                                currentSelectedCard.pop()
                                                Card.cardAlreadySelected = false
                                            }
                                        }
                                    }) { _ ->
                                        if (Card.cardAlreadySelected && currentSelectedCard.getCards().size == 1) {
                                            if (it.push(currentSelectedCard.getCards()[0])) {
                                                if (cardSource is RemainingStack) {
                                                    (cardSource as RemainingStack).get()
                                                    int--
                                                    WHYDOESTHISWORKDAWG = true
                                                } else {
                                                    val aS = (cardSource as PlayStack)
                                                    for (i in currentSelectedCard.getCards()) aS.pop()
                                                    aS.actualStack.getOrNull(aS.actualStack.size - 1)?.show =
                                                        true
                                                    aS.a.getOrNull(aS.a.size - 1)?.show = true
                                                    WHYDOESTHISWORKDAWG = true
                                                }
                                                currentSelectedCard.pop()
                                                Card.cardAlreadySelected = false
                                            }
                                        }
                                    }
                                }
                            }
                            Box() {
                                    ShowCards(currentSelectedCard) {
                                            currentSelectedCard.pop(); Card.cardAlreadySelected = false
                                    }
                            }
                        }
                    }
            }


    }
    init {
        val cards= mutableListOf<Card>()
        var i=0
        var j=0
        while (i<4) {
            while (j<13) {
                cards.add(Card(i,j,false))
                j++
            }
            i++
            j=0
        }
        i =1
        while (i<8) {
            j=0
            val playStackCards = ArrayList<Card>()
            while (j<i) {
                playStackCards.add(cards.removeAt(cards.lastIndex))
                j++
            }
            playStacks.add( PlayStack(playStackCards))
            i++
        }
        val a :ArrayList<Card> = ArrayList<Card>()
        cards.forEach {
            a.add(it)
        }
        remainingStack=RemainingStack(a)
    }
}
@Composable
@Preview(heightDp = 412, widthDp = 785)
fun Prueba () {
    val a =MainActivity()
    a.MainView()
}