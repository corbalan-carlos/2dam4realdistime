package com.example.examenrecupcca

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
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
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.example.examenrecupcca.ui.theme.ExamenRecupCCATheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import kotlin.system.exitProcess


class MainActivity : ComponentActivity() {
	private val nombre = mutableStateOf("")
	private val edad = mutableStateOf(0)
	private val edadS = mutableStateOf("")
	private lateinit var aboutIntent:Intent
	private lateinit var playersIntent: Intent

	override fun onResume() {
		super.onResume()
		aboutIntent = Intent(this, MainActivity2::class.java)
		playersIntent = Intent(this, MainActivity3::class.java)
		enableEdgeToEdge()
		setContent {
			ExamenRecupCCATheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					
						mainView()
					
				}
			}
		}
	}
	/*
	La vista principal cuenta con tanto el remember de las variables de login
	 */
	@Preview
	@Composable
	fun mainView (modifier:Modifier = Modifier) {
		//La estructura base de la actividad
		Scaffold (
			topBar = {
					Image(painter = painterResource(id=R.drawable.anothertrillion), null,
						contentScale = ContentScale.FillWidth)
			},
			bottomBar = {
				
				close()
			}
		) { innerPadding ->
			Box (contentAlignment = Alignment.TopEnd, modifier = Modifier.fillMaxSize().padding( innerPadding)) {
					Column(Modifier.fillMaxWidth().padding(vertical = Dp(20f)), horizontalAlignment = Alignment.CenterHorizontally) {
						login(modifier = Modifier.padding(vertical = 20.dp))
						

						Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
							Button(onClick = {
								if (edad.value<16) {
									Toast.makeText(
										this@MainActivity,
										"Edad insuficiente",
										Toast.LENGTH_SHORT
									).show()
									return@Button
								}
								val nombreEdadB = Bundle()
								nombreEdadB.putString("nombre",nombre.value)
								nombreEdadB.putInt("edad",edad.value)
								aboutIntent.putExtras(nombreEdadB)
								this@MainActivity.startActivity(aboutIntent)
							}) {
								Text("Acerca de:")
							}
							Button(
								onClick =  {
									this@MainActivity.startActivity(playersIntent)
								}
							) {
								Text("Jugadores:")
							}
						}

				}
			}
		}
	}
	/*
	Los dos campos requeridos para la vista "Acerca de"
	*/
	@Composable
	fun login(modifier: Modifier = Modifier) {
			Row (Modifier.defaultMinSize(Dp(120f)), verticalAlignment = Alignment.CenterVertically) {
				Text(modifier = Modifier.width(Dp(200f)),text="Nombre de usuario:")
				TextField(
					modifier = Modifier.width(Dp(90f)),
					value = nombre.value,
					onValueChange = {
						newValue ->
						nombre.value = newValue
					}
				)
			}
			Row (Modifier.defaultMinSize(Dp(120f)), verticalAlignment = Alignment.CenterVertically){
				Text("Edad del usuario:",Modifier.width(Dp(200f)))
				TextField(
					modifier = Modifier.width(Dp(90f)),
					value = edadS.value,
					onValueChange = {
						edad.value= it.toIntOrNull()?:0;
						edadS.value= it
					}
				)
			}
		
	}

	/*
         El boton "Salir" de abajo de la actividad
         sale de la aplicacion (lol)
         */
	@Composable
	fun close(modifier: Modifier= Modifier) {
		Row( horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().padding(vertical = Dp(15f))) {
			Button(
				onClick = {
					val exitIntent = Intent(Intent.ACTION_MAIN)
					exitIntent.addCategory(Intent.CATEGORY_HOME)
					exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
					this@MainActivity.startActivity(exitIntent)
				},

				) {
				Text("Salir")
			}
		}
	}


}
