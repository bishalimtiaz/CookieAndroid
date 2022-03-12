package com.cookieTech.cookieandroid.core.base

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun ScreenBody(
    body: @Composable () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home",
                    )
                }
            )
        },
    ){
        body()
    }

}