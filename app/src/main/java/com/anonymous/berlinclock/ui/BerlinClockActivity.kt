package com.anonymous.berlinclock.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anonymous.berlinclock.R
import com.anonymous.berlinclock.domain.LampState
import com.anonymous.berlinclock.model.BerlinClockState
import com.anonymous.berlinclock.ui.theme.BerlinClockTheme
import com.anonymous.berlinclock.ui.theme.redEnabled
import com.anonymous.berlinclock.ui.theme.yellowEnabled

class BerlinClockActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BerlinClockTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainView()
                }
            }
        }
    }
}

    @Composable
    fun MainView() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.app_name))
                    }
                )
            }
        ) {
            BerlinClockView()
        }
    }

    @Composable
    fun BerlinClockView() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val berlinClockState = BerlinClockState.initialState()
            val enabled = berlinClockState.secondsLampState != LampState.OFF
            val color = if (enabled) Color(0xFFFFFF33) else Color(0xFF666633)
            //Seconds view
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .testTag("secondsLamp")
                    .background(color = color, shape = CircleShape)
            )
            //Top Hours view
            val topHours = berlinClockState.topHoursLampState
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                topHours.forEachIndexed { i, lamp ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(80.dp)
                            .background(color = redEnabled, shape = RoundedCornerShape(4.dp))
                            .testTag("topHourLamp${i+1}")
                    )
                }
            }
            //Bottom hours view
            val bottomHours = berlinClockState.bottomHoursLampState
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                bottomHours.forEachIndexed { i, lamp ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(80.dp)
                            .background(color = redEnabled, shape = RoundedCornerShape(4.dp))
                            .testTag("bottomHourLamp${i+1}")
                    )
                }
            }
            // Top Minutes view
            val topMinutes = berlinClockState.topMinutesLampState
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                topMinutes.forEachIndexed { i, lamp ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(80.dp)
                            .background(color = yellowEnabled, shape = RoundedCornerShape(4.dp))
                            .testTag("topMinutesLamp${i+1}")
                    )
                }
            }
            // Bottom Minutes view
            val bottomMinutes = berlinClockState.bottomMinutesLampState
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                bottomMinutes.forEachIndexed { i, lamp ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(80.dp)
                            .background(color = yellowEnabled, shape = RoundedCornerShape(4.dp))
                            .testTag("bottomMinutesLamp${i+1}")
                    )
                }
            }
            //Time text
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.testTag("timeText"),
                text = "11:59:59",
                fontSize = 30.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
    }