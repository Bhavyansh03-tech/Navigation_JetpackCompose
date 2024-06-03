package com.example.nested_nav_graph.navigation

const val DETAIL_SCREEN_ID = "id"
const val DETAIL_SCREEN_NAME = "name"

// Routes :
const val ROOT_ROUTE = "root"
const val HOME_ROUTE = "home"
const val AUTHENTICATION_ROUTE = "authentication"

sealed class ScreenName(val route: String) {
    data object Home : ScreenName(route = "home_screen")
    data object Detail : ScreenName(route = "detail_screen/{$DETAIL_SCREEN_ID}/{$DETAIL_SCREEN_NAME}"){
        fun passNameAndId(
            id: Int,
            name: String
        ): String {
            return "detail_screen/$id/$name"
        }
    }
    data object Login : ScreenName(route = "login_screen")
    data object Signup : ScreenName(route = "signup_screen")
}