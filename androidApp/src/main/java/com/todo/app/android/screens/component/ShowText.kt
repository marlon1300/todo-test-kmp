package com.todo.app.android.screens.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.todo.app.android.R

@Composable
fun ShowText(
    label: String,
    text: String,
    textFieldModifier: Modifier = Modifier,
    icon: Int = com.todo.app.R.drawable.vec_ic_email,
) {
    Column {
        TextBody(text = label)
        Spacer(Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(24.dp),
                painter = painterResource(id = icon),
                contentDescription = null
            )
            Spacer(Modifier.width(12.dp))
            Text(
                text=text,
                modifier = textFieldModifier.fillMaxWidth().weight(1f)
            )
        }
        Spacer(Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ShowText_Preview() {
    ShowText(label = "Email Address", text = "test@test.com")
}