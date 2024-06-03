package com.example.nested_nav_graph.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
            route = ScreenName.Detail.route,
            // Passing Arguments :->
            arguments = listOf(
                navArgument(DETAIL_SCREEN_ID){
                type = NavType.IntType
            },
                navArgument(DETAIL_SCREEN_NAME){
                    type = NavType.StringType
                }
            )
        ){
            val id = it.arguments?.getInt(DETAIL_SCREEN_ID)
            val name = it.arguments?.getString(DETAIL_SCREEN_NAME)
            DetailScreen(navController = navController, id!!, name.toString())
        }
    }
}