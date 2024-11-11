package com.todo.app.data

import co.touchlab.kermit.Logger
import com.todo.app.data.api.ToDoApiImpl
import com.todo.app.data.api.toLoginResult
import com.todo.app.data.api.toToDos
import com.todo.app.domain.ToDoRepository
import com.todo.app.model.LoginResult
import com.todo.app.model.ToDo
import com.todo.app.model.ToDos

class TodoRepositoryImpl(
    private val todoApi: ToDoApiImpl,
//    db: ToDoDatabase
) : ToDoRepository {

//    private val queries = db.todoQueries

    override suspend fun insertToDo(todo: ToDo) {
//        queries.insertToDo(id = todo.id, todo = todo.todo)
    }

    override suspend fun getNoteById(id: Long): ToDo? {
        TODO("Not yet implemented")
//        return queries.getToDoById(id = id).executeAsOneOrNull()?.toToDo()
    }

    override suspend fun getAllToDos(): List<ToDo> {
        TODO("Not yet implemented")
//        return queries.getAllToDos().executeAsList().map { it.toToDo() }
    }

    override suspend fun deleteToDoById(id: Long) {
//        queries.deleteTodo(id)
    }

    override suspend fun fetchToDos(): ToDos {
        Logger.d { "fetching todos..." }
        return todoApi.fetchToDos().toToDos()
    }

    override suspend fun login(username: String, password: String): LoginResult {
        Logger.d { "logging in..." }
        return todoApi.login(username, password).toLoginResult()
    }
}