package com.anonymous.berlinclock.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.anonymous.berlinclock.R

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

    }

    @Composable
    fun BerlinClockTheme(content: @Composable () -> Unit) {
        MaterialTheme(
            colors = lightColors(),
            typography = Typography(),
            shapes = Shapes(),
            content = content
        )
    }