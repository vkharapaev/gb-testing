package com.geekbrains.myfirsttests

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test

class WeatherUtilsTest {

    @Test
    fun weatherUtils_toFahrenheit() {
        TestCase.assertEquals(WeatherUtils.toFahrenheit(100f), 212f)
    }

    @Test
    fun weatherUtils_toFahrenheit_NotEquals() {
        Assert.assertNotEquals(WeatherUtils.toFahrenheit(100.51f), 212f)
    }

    @Test
    fun weatherUtils_toFahrenheitArray() {
        Assert.assertArrayEquals(
            WeatherUtils.toFahrenheit(floatArrayOf(0f, 50f, 100f, 200f)),
            floatArrayOf(32f, 122f, 212f, 392f),
            0.01f
        )
    }

    @Test
    fun weatherUtils_toFahrenheitArray_NullArray() {
        Assert.assertNull(WeatherUtils.toFahrenheit(null))
    }

    @Test
    fun weatherUtils_toFahrenheitArray_NoneNullArray() {
        Assert.assertNotNull(WeatherUtils.toFahrenheit(floatArrayOf()))
    }

}