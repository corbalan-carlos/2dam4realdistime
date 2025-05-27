package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NonSkippableComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

    @Composable
    fun ShowCards(prueba: StackBuffer,updater: (()->Unit)?) {
            val stack=prueba.actualStack
            val showcoefficient=prueba.showcoefficient
            Box(
                Modifier.width(66.dp)
                    .height((100 + ((stack.size - 1) * 100 * showcoefficient)).dp)
            )
            {
                var a = 0f
                for (it in stack ){ it.show = true }
                for (it in stack) {
                    Row(
                        Modifier.fillMaxWidth().padding(top = a.dp),
                        Arrangement.spacedBy((-100 * showcoefficient).dp)
                    ) {
                        it.ShowCard({}, updater)
                    }
                    a += (100 * showcoefficient)
                }
            }

    }

/*@Preview
@Composable
fun Adios() {
    val a = remember { mutableStateListOf<Card>() }
    val c = StackBuffer(a)

    c.push(mutableListOf( Card(0,0,true)))
    ShowCards(c) { }
    produceState(null,) {
        value=null
        c.push(mutableListOf( Card(1,0,true)))
    }

}*/