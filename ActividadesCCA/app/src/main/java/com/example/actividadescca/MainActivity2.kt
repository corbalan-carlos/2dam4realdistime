package com.example.actividadescca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

class MainActivity2 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        enableEdgeToEdge()
        setContent {
            Scaffold (Modifier.fillMaxSize()){ innerPadding->
                ops()
            }

        }
    }
    @Composable
    fun ops(modifier: Modifier=Modifier) {
        val resStr = remember { mutableStateOf("") }
        val int1 =intent.extras!!.getInt("n1")
        val int2 =intent.extras!!.getInt("n2")
        val bundleToDeposit = MainActivity.bundle
        Box (contentAlignment = Alignment.Center, modifier = Modifier.padding(vertical = Dp(100f))) {
            Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Row() {
                    Button(
                        onClick = {
                            if (int2 == 0) {
                                resStr.value = "Infinity"
                            } else {
                                resStr.value = (int1 / int2).toString()
                                bundleToDeposit.putInt("res",(int1 / int2))
                            }
                        }
                    ) {
                        Text("/")
                    }
                    Button(
                        onClick = {
                            resStr.value = (int1 * int2).toString()

                            bundleToDeposit.putInt("res", (int1 * int2))
                        }
                    ) {
                        Text("*")
                    }
                    Button(
                        onClick = {
                            resStr.value = (int1 + int2).toString()

                            bundleToDeposit.putInt("res", (int1 + int2))
                        }
                    ) {
                        Text("+")
                    }

                    Button(
                        onClick = {
                            resStr.value = (int1 - int2).toString()

                            bundleToDeposit.putInt("res", (int1 - int2))
                        }
                    ) {
                        Text("-")
                    }
                }
                Text(resStr.value)
                Button(onClick = {
                    this@MainActivity2.finish()
                }) { Text("Volver") }

            }
        }
    }
}