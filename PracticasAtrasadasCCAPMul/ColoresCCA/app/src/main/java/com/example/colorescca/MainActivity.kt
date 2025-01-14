package com.example.colorescca

import android.content.Context
import android.content.ContextParams
import android.content.ContextWrapper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.colorescca.ui.theme.ColoresCCATheme
import android.content.res.Resources
import android.util.Log
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Scaffold(modifier = Modifier.fillMaxSize()
            ) { innerPadding ->
                        Greeting()

                    }
                }

        }

    @Composable
    fun Greeting( modifier: Modifier = Modifier) {
        val myColors = remember { R.array.stringsMisColores }
        val resources = ContextWrapper(this).resources
        val options = remember { mutableStateOf(resources.getStringArray(myColors)[0]) }
        val myPaintableColors = arrayOf(
            R.color.azul, R.color.gris, R.color.rojo,
            R.color.marron, R.color.beige, R.color.amarillo, R.color.naranja,
            R.color.verde, R.color.purple_500, R.color.negro
        )

        val actualColor = remember { mutableStateOf(0x00fffffff)}
        Surface (Modifier.fillMaxSize(), color = Color(actualColor.value)
        )
            {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    resources.getStringArray(myColors).forEach {
                        Row(Modifier.selectable(
                            selected = (it == options.value),
                            onClick = {
                                options.value = it
                                when (it) {
                                    "Azul" -> actualColor.value=resources.getColor(myPaintableColors[0],null)
                                    "Gris" -> actualColor.value=resources.getColor(myPaintableColors[1],null)
                                    "Rojo" -> actualColor.value=resources.getColor(myPaintableColors[2],null)
                                    "Marron" -> actualColor.value=resources.getColor(myPaintableColors[3],null)
                                    "Beige" -> actualColor.value=resources.getColor(myPaintableColors[4],null)
                                    "Amarillo" -> actualColor.value=resources.getColor(myPaintableColors[5],null)
                                    "Naranja" -> actualColor.value=resources.getColor(myPaintableColors[6],null)
                                    "Verde" -> actualColor.value=resources.getColor(myPaintableColors[7],null)
                                    "Lila" -> actualColor.value=resources.getColor(myPaintableColors[8],null)
                                    "Negro"-> actualColor.value=resources.getColor(myPaintableColors[9],null)
                                }
                            }

                        )) {
                            RadioButton(
                                selected = (it == options.value),
                                onClick = null
                            )
                            Text(text = it)
                        }
                    }
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ColoresCCATheme {
        Column (verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally){
            arrayOf("1","2","3").forEach {
                Text(modifier = Modifier.background(Color(0xfffff)), text = it)
            }
        }
    }
}

