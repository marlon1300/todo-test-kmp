package com.todo.app.android.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.todo.app.SharedRes
import com.todo.app.android.screens.BaseScreen
import com.todo.app.android.screens.component.ButtonPrimary
import com.todo.app.android.screens.component.TextBody
import com.todo.app.android.screens.component.TextTitle
import com.todo.app.android.stringResource
import com.todo.app.model.OnboardingData

@Composable
fun OnboardingScreen(toLogin: () -> Unit) {
    var pageNumber by remember { mutableIntStateOf(0) }
    val onboardingSteps by remember { mutableStateOf(OnboardingData.initData()) }
    BaseScreen {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Column {
                    when (pageNumber) {
                        0 -> OnboardingContent(onboardingSteps[pageNumber])
                        1 -> OnboardingContent(onboardingSteps[pageNumber])
                        2 -> OnboardingContent(onboardingSteps[pageNumber])
                    }

                    ButtonPrimary(
                        text = stringResource(id = SharedRes.strings.button_next),
                        action = {
                            if (pageNumber < 2) {
                                pageNumber += 1
                            } else {
                                toLogin()
                            }
                        })
                }
            }
        }
    }
}

@Composable
fun OnboardingContent(content: OnboardingData) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .width(213.dp)
                .height(277.dp),
            painter = painterResource(content.res.drawableResId),
            contentDescription = null
        )
        Spacer(Modifier.height(40.dp))
        TextTitle(text = stringResource(content.title))
        Spacer(Modifier.height(40.dp))
        TextBody(text = stringResource(content.body), textAlign = TextAlign.Center)
        Spacer(Modifier.height(40.dp))
    }
}

@Preview
@Composable
fun OnboardingScreen_Preview() {
    OnboardingScreen(toLogin = {})
}