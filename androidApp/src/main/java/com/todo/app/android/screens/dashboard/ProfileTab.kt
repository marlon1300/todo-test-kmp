package com.todo.app.android.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.todo.app.SharedRes
import com.todo.app.android.screens.BaseScreen
import com.todo.app.android.screens.component.ShowText
import com.todo.app.android.screens.component.TextBody
import com.todo.app.android.screens.component.TextTitle
import com.todo.app.android.stringResource

@Composable
fun ProfileTab(logout: () -> Unit) {
    BaseScreen(composable = {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(40.dp))
                TextTitle(text = stringResource(SharedRes.strings.profile_title))
                Image(
                    modifier = Modifier
                        .size(90.dp),
                    painter = painterResource(com.todo.app.R.drawable.img_profile_photo),
                    contentDescription = null
                )
                Spacer(Modifier.height(20.dp))
                TextBody(text = "John Doe")
                Spacer(Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .height(50.dp)
                        .background(
                            color = Color.Red.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(size = 32.dp)
                        )
                        .padding(vertical = 12.dp, horizontal = 32.dp)
                        .clickable { logout() },
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier
                                .size(24.dp),
                            painter = painterResource(id = com.todo.app.R.drawable.vec_ic_logout),
                            contentDescription = null
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            fontWeight = FontWeight.Bold,
                            text = stringResource(SharedRes.strings.button_logout),
                            color = Color.Red
                        )
                    }
                }
            }

            Spacer(Modifier.height(60.dp))
            TextBody(text = stringResource(SharedRes.strings.profile_title_info))
            Spacer(Modifier.height(40.dp))
            ShowText(
                icon = com.todo.app.R.drawable.vec_ic_tab_profile,
                label = stringResource(SharedRes.strings.profile_title_full_name),
                text = "John Doe"
            )
            Spacer(Modifier.height(24.dp))
            ShowText(
                icon = com.todo.app.R.drawable.vec_ic_tab_profile,
                label = stringResource(SharedRes.strings.profile_title_email_address),
                text = "johndoe@gmail.com"
            )
        }
    })
}

@Preview
@Composable
fun ProfileTab_Preview() {
    ProfileTab {}
}