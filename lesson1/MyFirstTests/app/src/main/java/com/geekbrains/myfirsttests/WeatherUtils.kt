package com.geekbrains.myfirsttests

class WeatherUtils {
    companion object {
        fun toFahrenheit(celsius: Float): Float {
            return celsius * 9 / 5f + 32
        }

        fun toFahrenheit(celsius: FloatArray?): FloatArray? {
            celsius ?: return null
            return FloatArray(celsius.size).apply {
                celsius.forEachIndexed { idx, value ->
                    this[idx] = toFahrenheit(value)
                }
            }
        }
    }
}