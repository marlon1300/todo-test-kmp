package com.todo.app.android.screens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextBody(
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = Color.Black
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge.copy(
            color = textColor,
            textAlign = textAlign
        )
    )
}
@Preview(showBackground = true)
@Composable
fun TextSubHeader_Preview() {
    TextBody("Test")
}