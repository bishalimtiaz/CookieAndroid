package com.cookieTech.cookieandroid.modules.landing.bottomNav

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavHostController){
    val navBarItems = listOf(
        NavBarItem.Home,
        NavBarItem.Offline,
        NavBarItem.Profile,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
    ) {
        navBarItems.forEach{ navBarItem ->
            AddItem(navBarItem = navBarItem, currentDestination = currentDestination, navController = navController)
        }
    }

}

@Composable
fun RowScope.AddItem(
    navBarItem: NavBarItem,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem(
        label = {
            Text(text = navBarItem.title)
        },
        icon = {
            Icon(painter = painterResource(id = navBarItem.icoDrawableId), contentDescription = "Navigation Item")
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == navBarItem.screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(navBarItem.screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )

}