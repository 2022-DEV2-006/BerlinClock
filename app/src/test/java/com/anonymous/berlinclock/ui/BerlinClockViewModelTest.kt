package com.anonymous.berlinclock.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anonymous.berlinclock.domain.BerlinClock
import com.anonymous.berlinclock.model.BerlinClockState
import com.anonymous.berlinclock.utils.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BerlinClockViewModelTest {

    private val berlinClock = BerlinClock()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: BerlinClockViewModel

    @Before
    fun setUp(){
        viewModel = BerlinClockViewModel(berlinClock)
    }

    @Test
    fun `should initialize berlin clock when init function called`(){
        viewModel.initBerlinClock()

        val value = viewModel.berlinClockState.getOrAwaitValue()
        val expectedResult = BerlinClockState.initialState()

        assertThat(value).isEqualTo(expectedResult)
    }
} 