package com.cookieTech.cookieandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import com.cookieTech.cookieandroid.data.remote.FoodApi
//import com.cookieTech.cookieandroid.data.remote.FoodApi
import com.cookieTech.cookieandroid.navigation.nav_graph.SetupNavHost
import com.cookieTech.cookieandroid.ui.theme.CookieAndroidTheme
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

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