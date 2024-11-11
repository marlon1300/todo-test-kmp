package com.todo.app.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.todo.app.domain.ToDoRepository
import com.todo.app.model.LoginResult
import com.todo.app.model.ToDos


class ToDoViewModel(
    private val toDoRepository: ToDoRepository,
) : ViewModel() {
    suspend fun fetchToDos(): ToDos {
        return toDoRepository.fetchToDos()
    }

    suspend fun login( username: String,  password: String): LoginResult {
        return toDoRepository.login(username = username, password = password)
    }
}