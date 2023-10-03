package com.example.temperatureconverter

import org.junit.Assert.assertEquals
import org.junit.Test

class ConverterTest{
    @Test
    fun celsius_toFahrenheit(){
        assertEquals(Converter().convertToFahrenheit(100.00),212.0, 0.0)
        assertEquals(Converter().convertToFahrenheit(0.00),32.0, 0.0)
    }

    @Test
    fun fahrenheit_toCelsius(){
        assertEquals(Converter().convertToCelsius(32.0),0.0, 0.0)
        assertEquals(Converter().convertToCelsius(212.0),100.0, 0.0)
    }
}