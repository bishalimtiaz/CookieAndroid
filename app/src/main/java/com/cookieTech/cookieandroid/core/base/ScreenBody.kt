package com.cookieTech.cookieandroid.core.base

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun ScreenBody(

    topBar: @Composable (() -> Unit)? = null,
    body: @Composable () -> Unit,
) {
    Scaffold(
        topBar = topBar ?: {},
    ) {
        body()
    }

}