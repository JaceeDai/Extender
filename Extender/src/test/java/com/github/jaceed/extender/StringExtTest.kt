package com.github.jaceed.extender

import com.github.jaceed.extender.standard.availableWith
import com.github.jaceed.extender.standard.orBy
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.IllegalStateException

/**
 * Created by Jacee.
 * Date: 2022.02.10
 */
class StringExtTest {

    private var testString: CharSequence? = null

    @Test(expected = IllegalStateException::class)
    fun availableWith_null_to_exception() {
        testString.availableWith("")
    }

    @Test
    fun availableWith_null_to_default() {
        assertEquals(testString.availableWith("abc"), "abc")
    }

    @Test
    fun availableWith_empty_to_default() {
        testString = ""
        assertEquals(testString.availableWith("abc"), "abc")
    }

    @Test
    fun availableWith_available() {
        testString = "abc"
        assertEquals(testString.availableWith("test"), "abc")
    }

    @Test
    fun orBy_null_to_empty() {
        assertEquals(testString orBy null, "")
    }

    @Test
    fun orBy_null_to_useful() {
        assertEquals(testString orBy "abc", "abc")
    }

    @Test
    fun orBy_empty_to_empty() {
        testString = ""
        assertEquals(testString orBy null, "")
    }

    @Test
    fun orBy_empty_to_useful() {
        testString = ""
        assertEquals(testString orBy "abc", "abc")
    }

    @Test
    fun orBy_available() {
        testString = "abc"
        assertEquals(testString orBy null, "abc")
        assertEquals(testString orBy "", "abc")
        assertEquals(testString orBy "test", "abc")
    }

}