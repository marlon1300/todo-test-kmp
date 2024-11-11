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
fun InputText(
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    text: String,
    onTextChanged: (String) -> Unit,
    invalid: Boolean = false,
    icon: Int = com.todo.app.R.drawable.vec_ic_email,
    secure: Boolean = false,
) {
    var toggle by remember { mutableStateOf(true) }
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
            Spacer(Modifier.width(8.dp))
            BasicTextField(
                visualTransformation = if (toggle && secure) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyLarge,
                value = text,
                onValueChange = { onTextChanged(it) },
                modifier = Modifier.fillMaxWidth().weight(1f)
            )
            if (secure) {
                Image(
                    modifier = Modifier.clickable { toggle = !toggle },
                    painter = painterResource(id = com.todo.app.R.drawable.vec_ic_eye),
                    contentDescription = null
                )
            }
        }
        Spacer(Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.LightGray)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InputName_Preview() {
    InputText(label = "Email Address", text = "test@test.com", onTextChanged = {})
}