package com.example.nested_nav_graph.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.nested_nav_graph.screen.LoginScreen
import com.example.nested_nav_graph.screen.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = ScreenName.Login.route,
        route = AUTHENTICATION_ROUTE
    ){
        composable(
            route = ScreenName.Login.route
        ){
            LoginScreen(navController = navController)
        }
        composable(
            route = ScreenName.Signup.route
        ){
            SignUpScreen(navController = navController)
        }
    }
}