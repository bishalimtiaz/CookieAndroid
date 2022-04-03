package com.cookieTech.cookieandroid.modules.search
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import com.cookieTech.cookieandroid.core.base.ScreenBody
import com.cookieTech.cookieandroid.core.widget.DefaultTopBar
import com.cookieTech.cookieandroid.core.widget.SearchTopBar
import com.cookieTech.cookieandroid.modules.mealFood.SearchFoodWidget
import com.cookieTech.cookieandroid.navigation.Screen

import com.example.screens.search.SearchWidget


@Composable
fun SearchScreen(navController: NavHostController) {

    ScreenBody(
        topBar = {
            SearchTopBar(
                text = "Search",
                {},
                {},
                {}
            )
        }
    ){


    }

}