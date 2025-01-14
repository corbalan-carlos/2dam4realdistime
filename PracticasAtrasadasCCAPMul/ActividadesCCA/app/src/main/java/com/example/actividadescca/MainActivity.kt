package com.example.actividadescca

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.actividadescca.ui.theme.ActividadesCCATheme

class MainActivity : ComponentActivity() {
    companion object {
        val bundle = Bundle()
    }
    override fun onResume() {
        super.onResume()
        enableEdgeToEdge()
        setContent {
            val n1:MutableState<Int?> = remember {  mutableStateOf(null) }
            val n2:MutableState<Int?> = remember { mutableStateOf(null) }
            val res:MutableState<Int?> = remember { mutableStateOf(null ) }
            val n1Str = remember { mutableStateOf("") }
            val n2Str = remember { mutableStateOf("") }
            Log.i("resultado",bundle.getInt("res").toString())
            ActividadesCCATheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {

                        Column (){
                            TextField (
                                value = n1Str.value,
                                onValueChange = {
                                    n1Str.value=it

                                }
                            )
                            TextField (
                                value = n2Str.value,
                                onValueChange = {
                                    n2Str.value=it
                                }

                            )
                            Button(
                                onClick = {
                                    n1.value=n1Str.value.toIntOrNull()
                                    n2.value=n2Str.value.toIntOrNull()
                                    bundle.putInt("n1",(if (n1.value == null) 0 else n1.value!!))
                                    bundle.putInt("n2",(if (n2.value == null) 0 else n2.value!!))
                                    bundle.putInt("res",(if (res.value == null) 0 else res.value!!))
                                    val intent=Intent(this@MainActivity,MainActivity2::class.java)
                                    intent.putExtras(bundle)
                                    startActivity(intent)
                                }
                            ) {
                                Text("Calcular")
                            }
                            Text(bundle.getInt("res").toString())
                        }

                    }
                }
            }
        }
    }
}
