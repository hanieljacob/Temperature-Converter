package com.example.temperatureconverter

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private lateinit var scenario: ActivityScenario<MainActivity>
    @Before
    fun setUp() {
        scenario = launch(MainActivity::class.java)
    }
    @After
    fun tearDown() {
        scenario.close()
    }
    @Test
    fun correctSeekbarProgressOnLaunch(){
        onView(withId(R.id.celsiusTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.celsiusTextViewValue)))
        onView(withId(R.id.fahrenheitTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.fahrenheitTextViewValue)))
    }
}
