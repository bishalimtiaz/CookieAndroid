package com.cookieTech.cookieandroid.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cookieTech.cookieandroid.modules.mealFood.MealFoodScreen
import com.cookieTech.cookieandroid.modules.profile.ProfileScreen
import com.cookieTech.cookieandroid.navigation.Route.BOTTOM_NAV
import com.cookieTech.cookieandroid.navigation.Screen

@Composable
fun SetupLandingNavHost(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = BOTTOM_NAV,

    ) {

        bottomNavGraph(navController = navController)
        composable(route = Screen.MealFood.route){
            MealFoodScreen(
                navController = navController
            )
        }

    }

}