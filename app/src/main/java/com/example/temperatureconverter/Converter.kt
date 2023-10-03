package com.example.temperatureconverter

class Converter {
    fun convertToCelsius(value: Double): Double{
        return (value - 32)*(5/9.0)
    }

    fun convertToFahrenheit(value: Double): Double{
        return (value * (9/5.0)) + 32
    }
}