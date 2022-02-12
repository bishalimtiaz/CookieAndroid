package com.cookieTech.cookieandroid.navigation

import com.cookieTech.cookieandroid.navigation.Route.LOGIN_ROUTE
import com.cookieTech.cookieandroid.navigation.Route.SPLASH_ROUTE

sealed class Screen(val route: String){
    object Splash : Screen(route = SPLASH_ROUTE)
    object Login : Screen(route = LOGIN_ROUTE)


}
