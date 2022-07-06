package com.anonymous.berlinclock.domain

import com.anonymous.berlinclock.domain.LampState.*

class BerlinClock {

    fun getLampStateForSeconds(seconds: Int): LampState {
        if (seconds == 1) {
            return OFF
        }
        return YELLOW
    }

}

enum class LampState {
    YELLOW,
    OFF
}