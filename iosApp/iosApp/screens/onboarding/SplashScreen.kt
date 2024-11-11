package com.todo.app.android.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.todo.app.android.R
import com.todo.app.android.screens.BaseScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(toOnboarding: () -> Unit) {
    BaseScreen(composable = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            LaunchedEffect(true) {
                delay(2000)
                toOnboarding()
            }
            Box(
                modifier = Modifier
                    .fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .width(135.dp)
                        .height(180.dp),
                    painter = painterResource(id = R.drawable.vec_ic_splash),
                    contentDescription = null
                )
            }
        }
    })
}

@Preview
@Composable
fun SplashScreen_Preview() {
    SplashScreen(toOnboarding = {})
}