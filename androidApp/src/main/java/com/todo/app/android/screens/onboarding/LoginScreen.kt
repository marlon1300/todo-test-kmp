package com.todo.app.android.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.todo.app.SharedRes
import com.todo.app.android.screens.BaseScreen
import com.todo.app.android.screens.component.ButtonPrimary
import com.todo.app.android.screens.component.ButtonSocial
import com.todo.app.android.screens.component.InputText
import com.todo.app.android.screens.component.TextBody
import com.todo.app.android.screens.component.TextTitle
import com.todo.app.android.stringResource
import com.todo.app.viewmodel.ToDoViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(toDashboard: () -> Unit) {
    var username by remember { mutableStateOf("emilys") }
    var password by remember { mutableStateOf("emilyspass") }
    val viewModel = koinViewModel<ToDoViewModel>()
    val scope = rememberCoroutineScope()
    var loginError by remember { mutableStateOf(false) }
    BaseScreen(composable = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            Image(
                modifier = Modifier
                    .width(44.dp)
                    .height(44.dp),
                painter = painterResource(com.todo.app.R.drawable.vec_ic_back),
                contentDescription = null
            )
            Spacer(Modifier.height(60.dp))
            TextTitle(text = stringResource(id = SharedRes.strings.login_label_title))
            Spacer(Modifier.height(40.dp))
            InputText(
                icon = com.todo.app.R.drawable.vec_ic_email,
                label = stringResource(id = SharedRes.strings.login_label_email),
                text = username,
                onTextChanged = { username = it })
            Spacer(Modifier.height(14.dp))
            InputText(
                secure = true,
                icon = com.todo.app.R.drawable.vec_ic_lock,
                label = stringResource(id = SharedRes.strings.login_label_password),
                text = password,
                onTextChanged = { password = it })

            Spacer(Modifier.height(24.dp))
            ButtonPrimary(text = "Log in", action = {
                scope.launch {
                    val result = viewModel.login(username, password)
                    if (result.username.isNotEmpty()) {
                        loginError = false
                        toDashboard()
                    } else {
                        loginError = true
                    }
                }
            })
            Spacer(Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .height(1.dp)
                        .background(Color.Gray)
                )
                Spacer(Modifier.width(4.dp))
                TextBody("or")
                Spacer(Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .height(1.dp)
                        .background(Color.Gray)
                )
            }
            Spacer(Modifier.height(24.dp))
            ButtonSocial(
                text = stringResource(id = SharedRes.strings.button_social_google),
                icon = com.todo.app.R.drawable.vec_ic_google,
                action = {})
            Spacer(Modifier.height(12.dp))
            ButtonSocial(
                text = stringResource(id = SharedRes.strings.button_social_apple),
                icon = com.todo.app.R.drawable.vec_ic_apple,
                action = {})
        }
    })
}

@Preview
@Composable
fun LoginScreen_Preview() {
    LoginScreen(toDashboard = {})
}