package com.todo.app.android.screens.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ButtonSocial(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    action: () -> Unit,
    icon: Int = com.todo.app.R.drawable.vec_ic_google,
) {
    Button(
        enabled = enabled,
        shape = RectangleShape, colors = ButtonDefaults.buttonColors(
            Color.LightGray
        ), onClick = action, modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(24.dp),
                painter = painterResource(id = icon),
                contentDescription = null
            )
            Spacer(Modifier.width(12.dp))
            Text(
                text = text, style = MaterialTheme.typography.labelLarge.copy(
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                ), modifier = Modifier.padding(vertical = 7.dp)
            )
        }

    }
}

@Preview()
@Composable
fun ButtonSocial_Preview() {
    ButtonSocial(text = "Next", action = {})
}
