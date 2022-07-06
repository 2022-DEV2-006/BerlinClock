package com.anonymous.berlinclock

import com.anonymous.berlinclock.domain.BerlinClock
import com.anonymous.berlinclock.domain.OFF
import com.anonymous.berlinclock.domain.YELLOW
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class BerlinClockTest {

    @Test
    fun `should return yellow state for 0 second`(){
        val berlinClock = BerlinClock()
        val lampState = berlinClock.getLampStateForSeconds(0)

        assertThat(lampState).isEqualTo(YELLOW)
    }

    @Test
    fun `should return off state for 1 seconds`(){
        val berlinClock = BerlinClock()
        val lampState = berlinClock.getLampStateForSeconds(1)

        assertThat(lampState).isEqualTo(OFF)
    }
}