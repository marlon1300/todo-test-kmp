package com.todo.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform