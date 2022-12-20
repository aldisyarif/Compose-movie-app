package com.aldi.submission

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aldi.submission.ui.component.TopBar
import com.aldi.submission.ui.navigation.NavigationItem
import com.aldi.submission.ui.navigation.Screen
import com.aldi.submission.ui.screen.about.AboutScreen
import com.aldi.submission.ui.screen.catalogue.CatalogueScreen
import com.aldi.submission.ui.screen.detail.DetailGameScreen
import com.aldi.submission.ui.screen.home.HomeScreen
import com.aldi.submission.ui.theme.SubmissionTheme

@Composable
fun GamekuApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute != Screen.DetailGame.route){
                TopBar()
            }
        },
        bottomBar = {
            if (currentRoute != Screen.DetailGame.route){
                BottomBar(navController = navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route){
                HomeScreen(
                    navigateToDetail = { gameId ->
                            navController.navigate(
                                Screen.DetailGame.createRoute("home",gameId)
                            )
                    }
                )
            }
            composable(Screen.Favorite.route){
                CatalogueScreen(
                    navigateToDetail = { gameId ->
                        navController.navigate(
                            Screen.DetailGame.createRoute("catalogue",gameId)
                        )
                    }
                )
            }
            composable(Screen.About.route){
                AboutScreen()
            }

            // detailGame
            composable(
                route = Screen.DetailGame.route,
                arguments = listOf(navArgument("gameId"){
                    type = NavType.IntType
                })
            ){
                val gameid = it.arguments?.getInt("gameId") ?: -1
                DetailGameScreen(
                    gameId = gameid,
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }

}

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    BottomNavigation(
        modifier = modifier
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon =  Icons.Default.Home, //Icon(painter = painterResource(id = R.drawable.ic_menu_home), contentDescription = null),
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_catalogue),
                icon =  Icons.Default.List,
                screen = Screen.Favorite
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_about),
                icon =  Icons.Default.Person,
                screen = Screen.About
            ),
        )
        
        BottomNavigation {
            navigationItems.map { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(text = item.title)
                    },
                    selected = currentRoute == item.screen.route,
                    selectedContentColor = colorResource(id = R.color.selected_menu),
                    unselectedContentColor = colorResource(id = R.color.white),
                    onClick = {
                        navController.navigate(item.screen.route){
                            popUpTo(navController.graph.findStartDestination().id){
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GamekuAppPreview() {
    SubmissionTheme {
        GamekuApp()
    }
}
