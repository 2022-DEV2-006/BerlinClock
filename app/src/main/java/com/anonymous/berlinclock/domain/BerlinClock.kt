package com.anonymous.berlinclock.domain

import com.anonymous.berlinclock.domain.LampState.*

class BerlinClock {

    fun getLampStateForSeconds(seconds: Int): LampState = if (seconds % 2 == 0) YELLOW else OFF

}

enum class LampState {
    YELLOW,
    OFF
}