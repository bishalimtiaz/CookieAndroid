package com.cookieTech.cookieandroid.modules.landing

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import com.cookieTech.cookieandroid.modules.landing.bottomNav.BottomBar
import com.cookieTech.cookieandroid.navigation.nav_graph.SetupLandingNavHost

@ExperimentalPagingApi
@Composable
fun LandingScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        SetupLandingNavHost(navController = navController)
    }
}

@Composable
@Preview
fun PreviewLandingScreen(){

}