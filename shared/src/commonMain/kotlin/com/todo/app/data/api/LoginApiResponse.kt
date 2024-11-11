package com.todo.app.data.api

import com.todo.app.model.LoginResult
import kotlinx.serialization.Serializable

@Serializable
data class LoginApiResponse(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val accessToken: String,
    val refreshToken: String,
)

fun LoginApiResponse.toLoginResult(): LoginResult {
    return LoginResult(
        id = id,
        username = username,
        email = email,
        firstName = firstName,
        lastName = lastName,
        gender = gender,
        image = image,
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}

@Serializable
data class Login(
    val username: String,
    val password: String,
    val expiresInMins: Int
)