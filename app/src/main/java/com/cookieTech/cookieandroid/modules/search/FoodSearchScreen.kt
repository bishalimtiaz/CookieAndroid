package com.cookieTech.cookieandroid.modules.search

import android.provider.Settings
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.cookieTech.cookieandroid.R
import com.cookieTech.cookieandroid.architecture.viewModels.FoodSearchViewModel
import com.cookieTech.cookieandroid.core.base.ScreenBody
import com.cookieTech.cookieandroid.core.widget.RoundedIconButton
import com.cookieTech.cookieandroid.core.widget.SearchTopBar
import com.cookieTech.cookieandroid.domain.models.SearchFoodItem
import com.cookieTech.cookieandroid.domain.models.Units
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest


@ExperimentalPagingApi
@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: FoodSearchViewModel = hiltViewModel()
) {
    val searchQuery by searchViewModel.searchQuery.collectAsState()

    val  searchResult = searchViewModel.searchResult.collectAsLazyPagingItems()




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
        ListContent(items = searchResult) { item ->
            searchViewModel.addFoodToHistory(item)
        }

    }


}



@Composable
fun ListContent(items:  LazyPagingItems<SearchFoodItem>,onAdd:(item:SearchFoodItem)->Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items){food->
            Log.d("paging_test", "ListContent: " + food)
            food?.let {
                ContentItem(item = food, onAdd)
            }

        }
    }
}


@Composable
fun ContentItem(item:SearchFoodItem,onAdd:(item:SearchFoodItem)->Unit) {
    Surface(modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = item.foodName,style = MaterialTheme.typography.subtitle1)
                Text(text = "${item.quantity}  ${item.unit!!.unit_symbol}",style = MaterialTheme.typography.body2)
            }
            RoundedIconButton(
                onClicked = { onAdd(item) },
                painter = painterResource(id = R.drawable.ic_plus)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun previewContentItem(){
    ContentItem(
        item = SearchFoodItem(
            1,
            "Apple",
            1f,
            1f,
            Units(1, "kilo calorie", "kcal", "energy")
        ),{

        }
    )
}


