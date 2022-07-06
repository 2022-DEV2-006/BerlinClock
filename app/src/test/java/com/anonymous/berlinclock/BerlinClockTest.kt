package com.anonymous.berlinclock

import com.anonymous.berlinclock.domain.BerlinClock
import com.anonymous.berlinclock.domain.LampState.*
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class BerlinClockTest {
    private lateinit var berlinClock: BerlinClock

    @Before
    fun setUp(){
        berlinClock = BerlinClock()
    }

    @Test
    fun `should return yellow state for 0 second`(){
        val lampState = berlinClock.getLampStateForSeconds(0)

        assertThat(lampState).isEqualTo(YELLOW)
    }

    @Test
    fun `should return off state for 1 seconds`(){
        val lampState = berlinClock.getLampStateForSeconds(1)

        assertThat(lampState).isEqualTo(OFF)
    }

    @Test
    fun `should return yellow state for 2 seconds`(){
        val lampState = berlinClock.getLampStateForSeconds(2)

        assertThat(lampState).isEqualTo(YELLOW)
    }
}