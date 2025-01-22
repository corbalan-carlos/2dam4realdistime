package com.example.examenrecupcca

import android.content.ContextWrapper
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.examenrecupcca.ui.theme.ui.theme.ExamenRecupCCATheme
import kotlin.math.max

class MainActivity3 : ComponentActivity() {
    val cWrapper = ContextWrapper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                mainPlayersView()
            }
        }

    @Preview
    @Composable
    fun mainPlayersView(modifier: Modifier=Modifier) {
        Scaffold (
            modifier = Modifier.fillMaxSize().padding(vertical = 30.dp),
            topBar = {
            },
            bottomBar = {
                close()
            }
        ) {
            innerPadding ->
                Box(Modifier.padding(innerPadding), contentAlignment = Alignment.Center) {
                    askForPlayers()
                }
        }
    }
    @Composable
    fun askForPlayers(modifier: Modifier =Modifier) {
        val options = listOf("Masculino","Femenino","Otro")
        val (selectedOption ,onSelectedOption)= remember { mutableStateOf(options[0]) }
            val sW= LocalConfiguration.current.screenWidthDp.dp.value
            val id = remember { mutableStateOf("") }
            val nombre = remember { mutableStateOf("") }
            val fApellido = remember { mutableStateOf("") }
        val sApellido = remember { mutableStateOf("") }
        val genero = remember { mutableStateOf("") }
        val fNac = remember { mutableStateOf("") }
        val altura = remember { mutableStateOf("") }
        val telf = remember { mutableStateOf("") }
        val mail = remember { mutableStateOf("") }
        val observaciones = remember { mutableStateOf("") }


        Column (modifier=Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Id", textAlign = TextAlign.Start,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    TextField(
                        modifier = Modifier.width((sW * 0.50).dp).padding(horizontal = 20.dp),
                        value = id.value,
                        onValueChange = {
                            id.value = it;
                        }
                    )
                }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Nombre", textAlign = TextAlign.Start,
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                        TextField(
                            modifier = Modifier.width((sW * 0.50).dp).padding(horizontal = 20.dp),
                            value = nombre.value,
                            onValueChange = {
                                nombre.value = it;
                            }
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Primer Apellido", textAlign = TextAlign.Start,
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                        TextField(
                            modifier = Modifier.width((sW * 0.50).dp).padding(horizontal = 20.dp),
                            value = fApellido.value,
                            onValueChange = {
                                fApellido.value = it;
                            }
                        )
                    }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Segundo Apellido ", textAlign = TextAlign.Start,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                TextField(
                    modifier = Modifier.width((sW * 0.50).dp).padding(horizontal = 20.dp),
                    value = sApellido.value,
                    onValueChange = {
                        sApellido.value = it;
                    }
                )
            }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Genero", textAlign = TextAlign.Start,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    Box(
                        modifier = Modifier.width((sW * 0.50).dp).padding(horizontal = 20.dp),
                    ) {
                        Column (verticalArrangement = Arrangement.SpaceEvenly){
                            Row (Modifier.selectable(
                                selected = (options[0]==selectedOption),
                                onClick =  {
                                    onSelectedOption(options[0])
                                },
                                role = Role.RadioButton
                            ), verticalAlignment = Alignment.CenterVertically){
                                RadioButton(
                                    selected = (options[0]==selectedOption),
                                    onClick = null
                                )
                                Text(text = options[0])
                            }
                            Row (Modifier.selectable(
                                selected = (options[1]==selectedOption),
                                onClick =  {
                                    onSelectedOption(options[1])
                                },
                                role = Role.RadioButton
                            ), verticalAlignment = Alignment.CenterVertically){
                                RadioButton(
                                    selected = (options[1]==selectedOption),
                                    onClick = null
                                )
                                Text(text = options[1])
                            }
                            Row (Modifier.selectable(
                                selected = (options[2]==selectedOption),
                                onClick =  {
                                    onSelectedOption(options[2])
                                },
                                role = Role.RadioButton
                            ), verticalAlignment = Alignment.CenterVertically){
                                RadioButton(
                                    selected = (options[2]==selectedOption),
                                    onClick = null
                                )
                                Text(text = options[2])
                            }}

                    }
                }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Fecha de nacimiento", textAlign = TextAlign.Start,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                TextField(
                    modifier = Modifier.width((sW * 0.50).dp).padding(horizontal = 20.dp),
                    value = fNac.value,
                    onValueChange = {
                        fNac.value = it;
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Altura ", textAlign = TextAlign.Start,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                TextField(
                    modifier = Modifier.width((sW * 0.50).dp).padding(horizontal = 20.dp),
                    value = altura.value,
                    onValueChange = {
                        altura.value = it;
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Telfono", textAlign = TextAlign.Start,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                TextField(
                    modifier = Modifier.width((sW * 0.50).dp).padding(horizontal = 20.dp),
                    value = telf.value,
                    onValueChange = {
                        telf.value = it;
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Mail ", textAlign = TextAlign.Start,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                TextField(
                    modifier = Modifier.width((sW * 0.50).dp).padding(horizontal = 20.dp),
                    value = mail.value,
                    onValueChange = {
                        mail.value = it;
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Observaciones ", textAlign = TextAlign.Start,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                TextField(
                    modifier = Modifier.width((sW * 0.50).dp).height(100.dp).padding(horizontal = 20.dp),
                    value = observaciones.value,
                    onValueChange = {
                        observaciones.value = it;
                    }
                )
            }

                    Button(
                        modifier = Modifier.padding(vertical = 30.dp),
                        onClick = {
                            if (selectedOption==options[1]) {
                                Toast.makeText(
                                    this@MainActivity3,
                                    "La jugadora ${nombre.value} ${fApellido.value} ${sApellido.value} mide ${altura.value}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                            else Toast.makeText(
                                this@MainActivity3,
                                "La jugador ${nombre.value} ${fApellido.value} ${sApellido.value} mide ${altura.value}",
                                Toast.LENGTH_LONG
                            ).show()

                        }
                    )
                    {
                        Text(text = "Info")
                    }
                }
    }
@Composable
fun close(modifier: Modifier= Modifier) {
    Row( horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().padding(vertical = Dp(15f))) {
        Button(
            onClick = {
                this@MainActivity3.finish()
            }
        ) {
            Text("Salir")
        }
    }
}

        private fun textRow (modifier: Modifier= Modifier,  sNext:MutableState<String> , sW:Float ):Unit{
            setContent {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = sNext.value, textAlign = TextAlign.Start,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    TextField(
                        modifier = Modifier.width((sW * 0.50).dp).padding(horizontal = 20.dp),
                        value = sNext.value,
                        onValueChange = {
                            sNext.value = it;
                        }
                    )
                }
            }
    }

}
