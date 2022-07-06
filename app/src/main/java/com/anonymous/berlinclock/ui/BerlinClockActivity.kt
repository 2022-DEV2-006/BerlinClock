package com.anonymous.berlinclock.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.anonymous.berlinclock.R
import com.anonymous.berlinclock.ui.theme.BerlinClockTheme

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
            val enabled = true
            val color = if (enabled) Color(0xFFFFFF33) else Color(0xFF666633)
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .testTag("secondsLamp")
                    .background(color = color, shape = CircleShape)
            )
        }
    }