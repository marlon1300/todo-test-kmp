package com.todo.app.domain

import com.todo.app.model.LoginResult
import com.todo.app.model.ToDo
import com.todo.app.model.ToDos

interface ToDoRepository {
    suspend fun insertToDo(todo: ToDo)
    suspend fun getNoteById(id: Long): ToDo?
    suspend fun getAllToDos(): List<ToDo>
    suspend fun deleteToDoById(id: Long)
    suspend fun fetchToDos(): ToDos
    suspend fun login(username: String, password: String): LoginResult
}