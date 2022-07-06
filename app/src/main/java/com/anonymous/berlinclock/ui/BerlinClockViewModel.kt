package com.anonymous.berlinclock.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.anonymous.berlinclock.domain.BerlinClock
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BerlinClockViewModel @Inject constructor(private val berlinClock: BerlinClock): ViewModel() {

}