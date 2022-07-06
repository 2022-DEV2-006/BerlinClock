package com.anonymous.berlinclock.domain

import com.anonymous.berlinclock.domain.LampState.*

class BerlinClock {

    fun getLampStateForSeconds(seconds: Int): LampState = if (seconds % 2 == 0) YELLOW else OFF

    fun getLampStateForTopMinutes(minutes: Int): List<LampState> = MutableList(11){OFF}

    fun getLampStateForBottomMinutes(minutes: Int): List<LampState> = MutableList(4){OFF}

}

enum class LampState {
    YELLOW,
    OFF
}