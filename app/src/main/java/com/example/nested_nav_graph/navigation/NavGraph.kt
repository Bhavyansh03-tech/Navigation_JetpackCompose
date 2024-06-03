package com.example.nested_nav_graph.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nested_nav_graph.screen.DetailScreen
import com.example.nested_nav_graph.screen.HomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenName.Home.route
    ){
        composable(
            route = ScreenName.Home.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = ScreenName.Detail.route
        ){
            DetailScreen(navController = navController)
        }
    }
}