package com.todo.app.android.screens.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ButtonPrimary(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    action: () -> Unit,
) {
    Button(
        enabled = enabled,
        shape = RectangleShape, colors = ButtonDefaults.buttonColors(
            Color.Blue
        ), onClick = action, modifier = modifier

            .fillMaxWidth()
    ) {
        Text(
            text = text, style = MaterialTheme.typography.labelLarge.copy(
                color = Color.White,
                textAlign = TextAlign.Center,
            ), modifier = Modifier.padding(vertical = 7.dp)
        )
    }
}

@Preview()
@Composable
fun ButtonPrimary_Preview() {
    ButtonPrimary(text = "Next", action = {})
}
