package com.anonymous.berlinclock.domain

import com.anonymous.berlinclock.domain.LampState.*

class BerlinClock {

    fun getLampStateForSeconds(seconds: Int): LampState = if (seconds % 2 == 0) YELLOW else OFF

    fun getLampStateForTopMinutes(minutes: Int): List<LampState> {
        val lampState = MutableList(11) { OFF }
        if (minutes == 5) {
            val topMinutes = minutes / 5
            lampState[topMinutes - 1] = YELLOW
        }
        return lampState
    }

    fun getLampStateForBottomMinutes(minutes: Int): List<LampState> {
        val lampState = MutableList(4){OFF}
        val bottomMinutes = minutes % 5
        (1..bottomMinutes).forEach{ i ->
            lampState[i - 1] = YELLOW
        }
        return lampState
    }

}

enum class LampState {
    YELLOW,
    OFF
}