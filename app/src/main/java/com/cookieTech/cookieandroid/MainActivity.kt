package com.cookieTech.cookieandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.cookieTech.cookieandroid.navigation.nav_graph.SetupNavGraph
import com.cookieTech.cookieandroid.ui.theme.CookieAndroidTheme

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

@Composable
fun MyApp() {
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CookieAndroidTheme {
        MyApp()
    }
}