package com.cookieTech.cookieandroid.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cookieTech.cookieandroid.modules.landing.LandingScreen
import com.cookieTech.cookieandroid.navigation.Route
import com.cookieTech.cookieandroid.navigation.Route.AUTH_ROUTE
import com.cookieTech.cookieandroid.navigation.Screen

@Composable
fun SetupNavHost(
    navController: NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = Route.AUTH_ROUTE,
    ){
        authNavGraph(navController = navController)
        composable(route = Screen.Landing.route) {
            LandingScreen()
        }


    }
}