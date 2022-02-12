package com.cookieTech.cookieandroid.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.cookieTech.cookieandroid.navigation.Route.APP_ROUTE
import com.cookieTech.cookieandroid.navigation.Route.AUTH_ROUTE


@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = AUTH_ROUTE,
        route = APP_ROUTE
    ){

       /* homeNavGraph(navController = navController)*/
        authNavGraph(navController = navController)



    }
}