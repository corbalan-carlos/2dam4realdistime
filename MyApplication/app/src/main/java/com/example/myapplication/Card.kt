package com.example.myapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Card (val suit:Int, val value:Int, var show: Boolean){
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
        Color.Blue,//Treboles,
        Color.Red,//Corazones,
        Color(150,100,60) //Diamantes
    )
    val suitToCharCorrespondence=listOf(
        "♤","♧","♡","♢"
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

    @Composable
    fun ShowCard() {

        if (this.show) {
            Box(
                modifier = Modifier.width(100.dp).height(150.dp)
                    .clip(RoundedCornerShape(5.dp,))
            ) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .clipToBounds()
                )
                {
                    Row(
                        Modifier.padding(9.dp).fillMaxHeight().fillMaxWidth(),
                        Arrangement.SpaceAround
                    ) {
                        Column {
                            Box(Modifier.align(Alignment.Start)) {
                                Text(
                                    text = numberToCardValue[value],
                                    color = suitToColorCorrespondence[suit]
                                )
                            }
                        }
                        Column(Modifier.fillMaxHeight(), Arrangement.Center) {
                            Box(Modifier.align(Alignment.CenterHorizontally)) {
                                Text(
                                    text = formattedStringToStringWSuits(),
                                    color = suitToColorCorrespondence[suit]
                                )
                            }
                        }
                        Column(Modifier.fillMaxHeight(), Arrangement.Bottom) {
                            Box(Modifier.align(Alignment.CenterHorizontally)) {
                                Text(
                                    text = numberToCardValue[value],
                                    color = suitToColorCorrespondence[suit]
                                )
                            }
                        }
                    }
                }
            }
        } else {
            Box(
                modifier = Modifier.width(100.dp).height(150.dp)
                    .clip(RoundedCornerShape(5.dp,))
            ) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    Box(Modifier.padding(3.dp).fillMaxSize().clip(RoundedCornerShape(5.dp,)))
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