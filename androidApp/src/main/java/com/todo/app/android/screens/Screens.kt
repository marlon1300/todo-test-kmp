package com.todo.app.android.screens

import kotlinx.serialization.Serializable

sealed class Screens {
    @Serializable
    data object Splash
    @Serializable
    data object Onboarding
    @Serializable
    data object Login
    @Serializable
    data object Dashboard
}