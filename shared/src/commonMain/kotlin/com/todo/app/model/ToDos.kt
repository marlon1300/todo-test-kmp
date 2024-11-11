package com.todo.app.model

data class ToDos(
    val todos: List<ToDo>,
    val total: Int,
    val skip: Int,
    val limit: Int,
)

data class ToDo(
    val id: Int,
    val todo: String,
    val completed: Boolean,
    val userId: Int,
)