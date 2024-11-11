package com.todo.app.android.screens.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.todo.app.android.screens.BaseScreen
import com.todo.app.model.ToDo
import com.todo.app.viewmodel.ToDoViewModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("MutableCollectionMutableState")
@Composable
fun HomeTab() {
    val viewmodel = koinViewModel<ToDoViewModel>()
    var todos by remember {
        mutableStateOf(
            mutableListOf<ToDo>()
        )
    }
    LaunchedEffect(true) {
        todos = viewmodel.fetchToDos().todos.toMutableList()
    }

    BaseScreen(composable = {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 50.dp)
        ) {
            todos.map { todo ->
                item {
                    Text(
                        text = todo.todo,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(vertical = 7.dp)
                            .background(
                                Color.Blue
                            ),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelLarge.copy(
                            color = Color.White
                        ),
                    )
                    Spacer(Modifier.height(2.dp))
                }
            }
        }
    })
}

@Preview
@Composable
fun HomeTab_Preview() {
    HomeTab()
}