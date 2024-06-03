package com.example.nested_nav_graph.navigation

const val DETAIL_SCREEN_ID = "id"
const val DETAIL_SCREEN_NAME = "name"

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
}