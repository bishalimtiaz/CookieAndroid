package com.cookieTech.cookieandroid.modules.landing.bottomNav

import androidx.annotation.DrawableRes
import com.cookieTech.cookieandroid.R
import com.cookieTech.cookieandroid.navigation.Screen

sealed class NavBarItem(
    val screen: Screen,
    val title: String,
    @DrawableRes
    val icoDrawableId: Int
){
    object Home: NavBarItem(
        screen = Screen.Home,
        title = "Home",
        icoDrawableId = R.drawable.ic_home
    )

    object Offline: NavBarItem(
        screen = Screen.Offline,
        title = "Offline",
        icoDrawableId = R.drawable.ic_offline
    )

    object Profile: NavBarItem(
        screen = Screen.Profile,
        title = "Profile",
        icoDrawableId = R.drawable.ic_profile
    )

}
