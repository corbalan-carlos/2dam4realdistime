package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val a =CircularLinkedList<Int>()
        a.put(10)
        assertEquals(a.size,1)
        assertEquals(a.remove(10),10)
        assertEquals(a.size,0)
        val b : OperationNotAllowedException=assertThrows(OperationNotAllowedException::class.java){ a.remove(0) }
        a.put(0)
        a.put(10)
        a.put(20)
        a.put(30)
        a.put(40)
        a.put(50)
        assertEquals(30,a.get(2))
        assertEquals(30,a.remove(2))
        assertEquals(40,a.get(2))

    }
}