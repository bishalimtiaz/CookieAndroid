package com.cookieTech.cookieandroid.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cookieTech.cookieandroid.modules.home.HomeScreen
import com.cookieTech.cookieandroid.modules.offline.OfflineScreen
import com.cookieTech.cookieandroid.modules.profile.ProfileScreen
import com.cookieTech.cookieandroid.navigation.Route.BOTTOM_NAV
import com.cookieTech.cookieandroid.navigation.Screen


fun NavGraphBuilder.bottomNavGraph(
    navController: NavHostController
){

    navigation(
        startDestination = Screen.Home.route,
        route = BOTTOM_NAV
    ) {
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Offline.route){
            OfflineScreen(
                navController = navController
            )
        }
        composable(route = Screen.Profile.route){
            ProfileScreen(
                navController = navController
            )
        }


    }

}