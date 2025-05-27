package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
import androidx.compose.runtime.NonSkippableComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import kotlin.math.roundToInt

class Card (val suit:Int, val value:Int, var show: Boolean){
    companion object {
        var cardAlreadySelected: Boolean = false
    }
    val numberToStringFormat=listOf (

        /*1*/"?",/*2*/"?\n?",/*3*/"?\n?\n?",/*4*/"?   ?\n?   ?",
        /*5*/"?  ?\n  ?\n?  ?",
        /*6*/"?  ?\n?  ?\n?  ?",
        /*7*/"?  ?\n  ?\n?  ?\n?   ?",
        /*8*/"?  ?\n  ?  \n?  ?\n  ?  \n?  ?",
        /*9*/"?  ?\n?  ?\n  ? \n?  ?\n?  ?",
       /*10*/"?  ?\n  ?\n?  ?\n?  ?\n  ?\n?  ?",
        /*J*/"?\n J\n   ?",
        /*Q*/"?\n Q\n   ?",
        /*K*/"?\n K\n   ?"

    )
    val numberToCardValue=listOf(
        "A","2","3","4","5","6","7","8","9","10","J","Q","K"
    )
    val suitToColorCorrespondence=listOf(
        Color.Black,//Picas
        Color.Red,//Corazones,
        Color.Blue,//Treboles,
        Color(150,100,60) //Diamantes
    )
    val suitToCharCorrespondence=listOf(
        "♤","♡","♧","♢"
    )
    fun formattedStringToStringWSuits() : String{
        var result = StringBuilder()
        for (i in numberToStringFormat[this.value]) {
            if (i=='?') {
                result.append(suitToCharCorrespondence[this.suit])
            } else {
                result.append(i)
            }
        }
        return result.toString()
    }
    @NonSkippableComposable
    @Composable
    fun ShowCard(updater: (Card)-> Unit, clickable: (()-> Unit)?, reverseClickable:  (() -> Unit) = {})  {
        if (this.show) {
            Box(
                modifier = Modifier
                    .clickable {
                        if (cardAlreadySelected && clickable!=null) {
                            clickable()
                        } else {
                            cardAlreadySelected=true
                            updater(this@Card)
                        }
                    }


            ) {
                Box(
                    Modifier
                        .width(66.dp).height(100.dp)
                        .background(Color.Black)
                    , Alignment.Center
                )
                {
                    Box(Modifier.width(64.dp).height(98.dp).background(Color.White)) {
                        Row(
                            Modifier.padding(6.dp).fillMaxHeight().fillMaxWidth(),
                            Arrangement.SpaceAround
                        ) {
                            Column {
                                Box(Modifier.align(Alignment.Start)) {
                                    Text(
                                        fontSize = 10.sp,
                                        text = numberToCardValue[value],
                                        color = suitToColorCorrespondence[suit]
                                    )
                                }
                            }
                            Column(Modifier.fillMaxHeight(), Arrangement.Center) {
                                Box(Modifier.align(Alignment.CenterHorizontally)) {
                                    Text(
                                        fontSize = 10.sp,
                                        text = formattedStringToStringWSuits(),
                                        color = suitToColorCorrespondence[suit]
                                    )
                                }
                            }
                            Column(Modifier.fillMaxHeight(), Arrangement.Bottom) {
                                Box(Modifier.align(Alignment.CenterHorizontally)) {
                                    Text(
                                        fontSize = 10.sp,
                                        text = numberToCardValue[value],
                                        color = suitToColorCorrespondence[suit]
                                    )
                                }
                            }
                        }
                    }
                }
            }
        } else {
            Box(
                modifier = Modifier.width(66.dp).height(100.dp)
                    .clickable { reverseClickable() }
                    .clip(RoundedCornerShape(2.dp,))
            ) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    Box(Modifier.padding(2.dp).fillMaxSize().clip(RoundedCornerShape(6.dp,)))
                    {
                        Box(Modifier.background(
                                Brush.linearGradient(
                                    listOf(Color.Red,Color.White),
                                    Offset(10f,50f), Offset(50f,10f),
                                    tileMode = TileMode.Repeated
                                )).fillMaxSize(
                                )
                        )
                    }

                }
            }
        }
    }
}


