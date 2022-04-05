package com.cookieTech.cookieandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import com.cookieTech.cookieandroid.navigation.nav_graph.SetupNavHost
import com.cookieTech.cookieandroid.ui.theme.CookieAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CookieAndroidTheme {
                MyApp()
            }
        }
    }
}

@ExperimentalPagingApi
@Composable
fun MyApp() {
    val navController = rememberNavController()
                          SetupNavHost(navController = navController)
}

@ExperimentalPagingApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CookieAndroidTheme {
        MyApp()
    }
}