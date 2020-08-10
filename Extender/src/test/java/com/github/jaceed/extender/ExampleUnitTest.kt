package com.github.jaceed.extender

import com.github.jaceed.extender.standard.anyOf
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
        assertEquals(4, 2 + 2)
    }

    @Test
    fun func_anyOf() {
        with (arrayOf("a", "b", null, "c")) {
            assertEquals("a" anyOf this, true)
            assertEquals("ab" anyOf this, false)
            assertEquals(null anyOf this, false)
        }
        with (arrayOf("a", "b", "c")) {
            "a" anyOf this
            assertEquals("a" anyOf this, true)
            assertEquals("ab" anyOf this, false)
        }
    }
}