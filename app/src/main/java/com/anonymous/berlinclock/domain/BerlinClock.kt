package com.anonymous.berlinclock.domain

import com.anonymous.berlinclock.domain.LampState.*

class BerlinClock {

    fun getLampStateForSeconds(seconds: Int): LampState = if (seconds % 2 == 0) YELLOW else OFF

    fun getLampStateForTopMinutes(minutes: Int): List<LampState> {
        val lampState = MutableList(11) { OFF }
        val topMinutes = minutes / 5
        (1..topMinutes).forEach { i ->
            if (i % 3 == 0){
                lampState[i - 1] = RED
            } else {
                lampState[i - 1] = YELLOW
            }
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

    fun getLampStateForTopHours(hours: Int) : List<LampState> {
        val lampState =  MutableList(4) { OFF }
        if (hours == 5){
            val topHours = hours / 5
            lampState[topHours - 1] = RED
        }
        return lampState
    }

    fun getLampStateForBottomHours(hours: Int): List<LampState> {
        val lampState = MutableList(4) { OFF }
        val bottomHours = hours % 5
        (1..bottomHours).forEach{ i ->
            lampState[i - 1] = RED
        }
        return lampState
    }

}

enum class LampState {
    YELLOW,
    OFF,
    RED
}