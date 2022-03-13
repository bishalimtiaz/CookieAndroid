package com.cookieTech.cookieandroid.modules.search
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems

import com.example.screens.search.SearchWidget

@ExperimentalPagingApi

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: FoodSearchViewModel = hiltViewModel()
) {
    val searchQuery by searchViewModel.searchQuery
//    val searchedFoods = searchViewModel.searchedFoods.collectAsLazyPagingItems()

//    Scaffold(
//        topBar = {
//            SearchWidget(
//                text = searchQuery,
//                onTextChange = {
//                    searchViewModel.updateSearchQuery(query = it)
//                },
//                onSearchClicked = {
//                    searchViewModel.searchHeroes(query = it)
//                },
//                onCloseClicked = {
//                    navController.popBackStack()
//                }
//            )
//        },
//        content = {
//            ListContent(items = searchedImages)
//        }
//    )
}