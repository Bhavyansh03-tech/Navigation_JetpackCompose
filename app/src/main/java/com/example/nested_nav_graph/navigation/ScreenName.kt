package com.example.nested_nav_graph.navigation

sealed class ScreenName(val route: String) {
    data object Home : ScreenName(route = "home_screen")
    data object Detail : ScreenName(route = "detail_screen")
}