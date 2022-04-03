package com.cookieTech.cookieandroid.navigation

import com.cookieTech.cookieandroid.navigation.Route.HOME_ROUTE
import com.cookieTech.cookieandroid.navigation.Route.LANDING_ROUTE
import com.cookieTech.cookieandroid.navigation.Route.LOGIN_ROUTE
import com.cookieTech.cookieandroid.navigation.Route.MEAL_FOOD_ROUTE
import com.cookieTech.cookieandroid.navigation.Route.OFFLINE_ROUTE
import com.cookieTech.cookieandroid.navigation.Route.PROFILE_ROUTE
import com.cookieTech.cookieandroid.navigation.Route.SEARCH_FOOD_ROUTE
import com.cookieTech.cookieandroid.navigation.Route.SPLASH_ROUTE

sealed class Screen(val route: String){
    object Splash: Screen(route = SPLASH_ROUTE)
    object Login: Screen(route = LOGIN_ROUTE)
    object Landing: Screen(route = LANDING_ROUTE)
    object Home: Screen(route = HOME_ROUTE)
    object Profile: Screen(route = PROFILE_ROUTE)
    object Offline: Screen(route = OFFLINE_ROUTE)
    object MealFood: Screen(route = MEAL_FOOD_ROUTE)
    object SearchScreen:Screen(route = SEARCH_FOOD_ROUTE)
}
