package com.todo.app.android.screens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TextTitle(
    text: String,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        style = MaterialTheme.typography.headlineLarge.copy(
            color = Color.Black,
            textAlign = textAlign
        )
    )
}
@Preview(showBackground = true)
@Composable
fun TextHeader_Preview() {
    TextTitle("Test")
}