package com.todo.app.data.api

import com.todo.app.model.ToDo
import com.todo.app.model.ToDos
import kotlinx.serialization.Serializable

@Serializable
data class FetchToDosApiResponse(
    val todos: List<FetchToDoApiResponse>,
    val total: Int,
    val skip: Int,
    val limit: Int,
)

@Serializable
data class FetchToDoApiResponse(
    val id: Int,
    val todo: String,
    val completed: Boolean,
    val userId: Int,
)

fun FetchToDosApiResponse.toToDos(): ToDos {
    return ToDos(
        todos = todos.map {
            ToDo(
                id = it.id,
                todo = it.todo,
                completed = it.completed,
                userId = it.userId
            )
        },
        skip = skip,
        total = total,
        limit = limit
    )
}
