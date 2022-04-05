package com.cookieTech.cookieandroid.modules.search

import android.util.Log
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import com.cookieTech.cookieandroid.architecture.viewModels.FoodSearchViewModel
import com.cookieTech.cookieandroid.core.base.ScreenBody
import com.cookieTech.cookieandroid.core.widget.SearchTopBar
import kotlinx.coroutines.delay


@ExperimentalPagingApi
@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: FoodSearchViewModel = hiltViewModel()
) {
    val searchQuery by searchViewModel.searchQuery

    ScreenBody(
        topBar = {
            SearchTopBar(
                text = searchQuery,
                onTextChange = {
                    searchViewModel.updateSearchQuery(query = it)
                },
                onCloseClicked = {
                    searchViewModel.clearSearchQuery()
                },
                onSearchClicked = {},
                onBackClicked = {
                    navController.popBackStack()
                }
            )
        }
    ) {


    }


}