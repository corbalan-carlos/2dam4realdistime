package com.example.bbdd

import kotlinx.coroutines.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
fun main () {
	runBlocking {
		launch {
			delay(5000L)
			println("World!")
		}
	}
	println("hello")
}

