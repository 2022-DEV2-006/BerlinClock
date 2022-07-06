package com.anonymous.berlinclock.domain

const val YELLOW = "YELLOW"
const val OFF = "OFF"

class BerlinClock {

    fun getLampStateForSeconds(seconds: Int): String {
        if (seconds == 1){
            return OFF
        }
        return YELLOW
    }

}