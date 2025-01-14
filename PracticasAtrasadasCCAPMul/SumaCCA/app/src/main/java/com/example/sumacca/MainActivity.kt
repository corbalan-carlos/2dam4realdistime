package com.example.sumacca

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.sumacca.ui.theme.SumaCCATheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import kotlin.math.log


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SumaCCATheme {
                MainFun( Modifier.padding(Dp(30f)))
            }
        }
    }
}
@Composable
fun MainFun (modifier: Modifier = Modifier) {
    var n1= remember { mutableStateOf("") }
    var n2= remember { mutableStateOf("") }
    var result:MutableState<Int?> = remember { mutableStateOf(null) }
    Column {
    Row (modifier=Modifier.padding(Dp(50f))) {
        Text("Primer numero:", modifier)
        TextField(value = n1.value, onValueChange = { n1.value = it })
    }
    Row (modifier=Modifier.padding(Dp(50f))){
        Text("Segundo numero:", modifier)
        TextField(value = n2.value, onValueChange = { n2.value = it })
    }
    Text(text =( result.value?.toString()?:""),
        Modifier.padding(Dp(20f))
    )
    Button(
        modifier = Modifier.padding(Dp(60f)),
        content = { Text("Sumar") },
        onClick = {
           result.value = n1.value.toIntOrNull()?:0
           Log.i("suma", result.value.toString())
           result.value=result.value?.plus(other = n2.value.toIntOrNull() ?: 0)
           Log.i("suma",n2.value.toIntOrNull().toString() ?: "null")
           Log.i("suma", result.value.toString())
   })

    }

}

@Preview(showBackground = true, name ="poggers")
@Composable
fun GreetingPreview() {
    SumaCCATheme {
        MainFun(Modifier.padding(Dp(30f)))
        }
    }
