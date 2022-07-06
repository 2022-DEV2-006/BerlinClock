package com.anonymous.berlinclock

import com.anonymous.berlinclock.domain.BerlinClock
import com.anonymous.berlinclock.domain.LampState.*
import com.anonymous.berlinclock.model.BerlinClockState
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

    @Test
    fun `should return off state for 3 seconds`(){
        val lampState = berlinClock.getLampStateForSeconds(3)

        assertThat(lampState).isEqualTo(OFF)
    }

    @Test
    fun `should return off for all lamps when minute is 0`(){
        val topLampState = berlinClock.getLampStateForTopMinutes(0)
        val bottomLampState = berlinClock.getLampStateForBottomMinutes(0)

        assertThat(topLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return first bottom lamp as yellow and others as off when minute is 1`(){
        val topLampState = berlinClock.getLampStateForTopMinutes(1)
        val bottomLampState = berlinClock.getLampStateForBottomMinutes(1)

        assertThat(topLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(YELLOW,OFF,OFF,OFF))
    }

    @Test
    fun `should return first two bottom lamp as yellow and others as off when minute is 2`(){
        val topLampState = berlinClock.getLampStateForTopMinutes(2)
        val bottomLampState = berlinClock.getLampStateForBottomMinutes(2)

        assertThat(topLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(YELLOW,YELLOW,OFF,OFF))
    }

    @Test
    fun `should return first three bottom lamp as yellow and others as off when minute is 3`(){
        val topLampState = berlinClock.getLampStateForTopMinutes(3)
        val bottomLampState = berlinClock.getLampStateForBottomMinutes(3)

        assertThat(topLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(YELLOW,YELLOW,YELLOW,OFF))
    }

    @Test
    fun `should return all bottom lamp as yellow and others as off when minute is 4`(){
        val topLampState = berlinClock.getLampStateForTopMinutes(4)
        val bottomLampState = berlinClock.getLampStateForBottomMinutes(4)

        assertThat(topLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(YELLOW,YELLOW,YELLOW,YELLOW))
    }

    @Test
    fun `should return all bottom lamp as off when minute is 5`(){
        val bottomLampState = berlinClock.getLampStateForBottomMinutes(5)

        assertThat(bottomLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return first top lamp as yellow and all bottom lamp as off when minute is 5`(){
        val topLampState = berlinClock.getLampStateForTopMinutes(5)
        val bottomLampState = berlinClock.getLampStateForBottomMinutes(5)

        assertThat(topLampState).isEqualTo(listOf(YELLOW,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return first top and bottom lamp as yellow when minute is 6`(){
        val topLampState = berlinClock.getLampStateForTopMinutes(6)
        val bottomLampState = berlinClock.getLampStateForBottomMinutes(6)

        assertThat(topLampState).isEqualTo(listOf(YELLOW,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(YELLOW,OFF,OFF,OFF))
    }

    @Test
    fun `should return first two top and all bottom lamp as yellow when minute is 14`(){
        val topLampState = berlinClock.getLampStateForTopMinutes(14)
        val bottomLampState = berlinClock.getLampStateForBottomMinutes(14)

        assertThat(topLampState).isEqualTo(listOf(YELLOW,YELLOW,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(YELLOW,YELLOW,YELLOW,YELLOW))
    }

    @Test
    fun `should return first two top as yellow and third as red all bottom lamp as off when minute is 15`(){
        val topLampState = berlinClock.getLampStateForTopMinutes(15)
        val bottomLampState = berlinClock.getLampStateForBottomMinutes(15)

        assertThat(topLampState).isEqualTo(listOf(YELLOW,YELLOW,RED,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return expected lamp state when minute is 45`(){
        val topLampState = berlinClock.getLampStateForTopMinutes(45)
        val bottomLampState = berlinClock.getLampStateForBottomMinutes(45)

        assertThat(topLampState).isEqualTo(listOf(YELLOW,YELLOW,RED,YELLOW,YELLOW,RED,YELLOW,YELLOW,RED,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return all lamp as off when hour is 0`(){
        val topLampState = berlinClock.getLampStateForTopHours(0)
        val bottomLampState = berlinClock.getLampStateForBottomHours(0)

        assertThat(topLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return first bottom lamp as red and others as off when hour is 1`(){
        val topLampState = berlinClock.getLampStateForTopHours(1)
        val bottomLampState = berlinClock.getLampStateForBottomHours(1)

        assertThat(topLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(RED,OFF,OFF,OFF))
    }

    @Test
    fun `should return first two bottom lamp as red and others as off when hour is 2`(){
        val topLampState = berlinClock.getLampStateForTopHours(2)
        val bottomLampState = berlinClock.getLampStateForBottomHours(2)

        assertThat(topLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(RED,RED,OFF,OFF))
    }

    @Test
    fun `should return all bottom lamp as red and others as off when hour is 4`(){
        val topLampState = berlinClock.getLampStateForTopHours(4)
        val bottomLampState = berlinClock.getLampStateForBottomHours(4)

        assertThat(topLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(RED,RED,RED,RED))
    }

    @Test
    fun `should return all bottom lamp as off when hour is 5`(){
        val bottomLampState = berlinClock.getLampStateForBottomHours(5)

        assertThat(bottomLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return first top lamp as red and all bottom lamp as off when hour is 5`(){
        val topLampState = berlinClock.getLampStateForTopHours(5)
        val bottomLampState = berlinClock.getLampStateForBottomHours(5)

        assertThat(topLampState).isEqualTo(listOf(RED,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return first top and bottom lamp as red when hour is 6`(){
        val topLampState = berlinClock.getLampStateForTopHours(6)
        val bottomLampState = berlinClock.getLampStateForBottomHours(6)

        assertThat(topLampState).isEqualTo(listOf(RED,OFF,OFF,OFF))
        assertThat(bottomLampState).isEqualTo(listOf(RED,OFF,OFF,OFF))
    }

    @Test
    fun `should return expected lamp state for given time`() {
        val actualState = berlinClock.getBerlinClockState("13:31:06")

        val secondsLampState = YELLOW
        val topMinutesLampState =
            listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutesLampState = listOf(YELLOW, OFF, OFF, OFF)
        val topHoursLampState = listOf(RED, RED, OFF, OFF)
        val bottomHoursLampState = listOf(RED, RED, RED, OFF)
        val expectedState = BerlinClockState(
            secondsLampState,
            topMinutesLampState,
            bottomMinutesLampState,
            topHoursLampState,
            bottomHoursLampState
        )

        assertThat(actualState).isEqualTo(expectedState)
    }
}