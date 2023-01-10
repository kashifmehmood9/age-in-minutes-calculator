package com.example.agecalculator

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

import org.junit.Assert.*
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testDemoClass() {
        val calculator = DateCalculator().calculateDate(0, 0, 0)
        assert(calculator.first == "00-01-0")
        assert(calculator.second == "1064014112")
    }
}