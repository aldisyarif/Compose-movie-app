package com.aldi.submission.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favorite : Screen("favorite")
    object About : Screen("about")
    object DetailGame : Screen("{fromScreen}/{gameId}"){
        fun createRoute(fromScreen: String, gameId: Int?) = "$fromScreen/$gameId"
    }
}