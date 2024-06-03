package com.example.nested_nav_graph.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.nested_nav_graph.screen.DetailScreen
import com.example.nested_nav_graph.screen.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = ScreenName.Home.route,
        route = HOME_ROUTE
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