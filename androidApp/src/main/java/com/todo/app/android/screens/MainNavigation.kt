package com.todo.app.android.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.todo.app.android.screens.dashboard.DashboardScreen
import com.todo.app.android.screens.onboarding.LoginScreen
import com.todo.app.android.screens.onboarding.OnboardingScreen
import com.todo.app.android.screens.onboarding.SplashScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Splash
    ) {
        composable<Screens.Splash> {
            SplashScreen(toOnboarding = { navController.navigate(Screens.Onboarding) })
        }
        composable<Screens.Onboarding> {
            OnboardingScreen(toLogin = { navController.navigate(Screens.Login) })
        }
        composable<Screens.Login> {
            LoginScreen(toDashboard = { navController.navigate(Screens.Dashboard) })
        }
        composable<Screens.Dashboard> {
            DashboardScreen(logout = { navController.navigate(Screens.Login) })
        }
    }
}