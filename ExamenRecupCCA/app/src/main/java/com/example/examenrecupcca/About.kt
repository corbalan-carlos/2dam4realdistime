package com.example.examenrecupcca

import MainUIBarProvider
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter

class About : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            allContent()
            }
    }
    @Composable
    fun allContent (){
        MainUIBarProvider.mainBar(this)
    }
    @Preview
    @Composable
    fun content() {
        Image (
            painter = painterResource(id = R.drawable.anothertrillion),
            contentDescription = "ANOTHER TRILLION RAHHH"
        )
    }




}

