package com.todo.app

import com.todo.app.domain.ToDoRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class KoinDependencies: KoinComponent {
    val toDoRepository: ToDoRepository by inject()
}