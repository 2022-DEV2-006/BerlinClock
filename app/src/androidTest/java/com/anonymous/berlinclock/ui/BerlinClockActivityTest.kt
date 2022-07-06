package com.anonymous.berlinclock.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.anonymous.berlinclock.ui.theme.BerlinClockTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class BerlinClockActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            BerlinClockTheme {
                MainView()
            }
        }
    }

    @Test
    fun shouldDisplayAppTitle() {
        with(composeTestRule) {
            val title = onNodeWithText("BerlinClock")

            title.assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplaySecondsLamp(){
        with(composeTestRule){
            val secondsButton = onNodeWithTag("secondsLamp")

            secondsButton.assertIsDisplayed()
        }
    }
}