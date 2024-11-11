package com.todo.app.data.api

import co.touchlab.kermit.Logger
import com.todo.app.model.CurrentUserResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

interface ToDoApi {
    suspend fun fetchToDos(): FetchToDosApiResponse
    suspend fun login(username: String, password: String): LoginApiResponse
    suspend fun getCurrentUser(accessToken: String): GetCurrentUserApiResponse
}

class ToDoApiImpl(private val httpClient: HttpClient) : ToDoApi {
    override suspend fun fetchToDos(): FetchToDosApiResponse {
        return try {
            val result = httpClient.get("https://dummyjson.com/todos").body<FetchToDosApiResponse>()
            return result
        } catch (e: Exception) {
            Logger.d { e.message.toString() }
            FetchToDosApiResponse(todos = emptyList(), skip = 0, total = 0, limit = 0)
        }
    }

    override suspend fun login(username: String, password: String): LoginApiResponse {
        return try {
            val endpoint = httpClient.post("https://dummyjson.com/auth/login") {
                contentType(ContentType.Application.Json)
                setBody(Login(username = username, password = password, expiresInMins = 3))
            }
            val result = endpoint.body<LoginApiResponse>()
            return result
        } catch (e: Exception) {
            Logger.d { e.message.toString() }
            LoginApiResponse(
                id = 0,
                username = "",
                email = "",
                firstName = "",
                lastName = "",
                gender = "",
                image = "",
                accessToken = "",
                refreshToken = ""
            )
        }
    }

    override suspend fun getCurrentUser(accessToken: String): GetCurrentUserApiResponse {
        return try {
            val endpoint = httpClient.get("https://dummyjson.com/auth/me") {

            }
            val result = endpoint.body<GetCurrentUserApiResponse>()
            return result
        } catch (e: Exception) {
            Logger.d { e.message.toString() }
            GetCurrentUserApiResponse(
                id = 0,
                username = "",
                email = "",
                firstName = "",
                lastName = "",
                gender = "",
                image = "",
            )
        }
    }
}