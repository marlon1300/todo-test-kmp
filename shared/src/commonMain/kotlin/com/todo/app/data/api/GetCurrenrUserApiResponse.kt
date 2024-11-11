package com.todo.app.data.api

import com.todo.app.model.CurrentUserResult
import kotlinx.serialization.Serializable

@Serializable
data class GetCurrentUserApiResponse(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
)

fun GetCurrentUserApiResponse.toCurrentUserResult(): CurrentUserResult {
    return CurrentUserResult(
        id = id,
        username = username,
        email = email,
        firstName = firstName,
        lastName = lastName,
        gender = gender,
        image = image
    )
}