package com.todo.app.android.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BaseScreen(composable: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .navigationBarsPadding()
            .background(Color.White)
            .padding(horizontal = 20.dp, vertical = 20.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        composable()
    }
}