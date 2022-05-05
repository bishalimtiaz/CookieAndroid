package com.cookieTech.cookieandroid.modules.mealFood

import android.text.Editable
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.paging.compose.items
import com.cookieTech.cookieandroid.R
import com.cookieTech.cookieandroid.core.widget.RoundedIconButton
import com.cookieTech.cookieandroid.core.base.ScreenBody
import com.cookieTech.cookieandroid.core.widget.DefaultTopBar
import com.cookieTech.cookieandroid.domain.models.SearchFoodItem
import com.cookieTech.cookieandroid.domain.models.Units
import com.cookieTech.cookieandroid.modules.ContentItem
import com.cookieTech.cookieandroid.modules.SingleTextAndIconsItem
import com.cookieTech.cookieandroid.navigation.Screen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MealFoodScreen(navController: NavHostController) {

    val tabData = listOf(
        "All",
        "Favorite",
        "Recipes",
        "Meals",
        "Create Food"
    )
    val pagerState = rememberPagerState(
        pageCount = tabData.size,
        initialOffscreenLimit = 2,
        infiniteLoop = true,
        initialPage = 0,
    )

    val coroutineScope = rememberCoroutineScope()

    ScreenBody(
        topBar = {
            DefaultTopBar(
                title = "BeakFast",
                elevation = 0.dp,
                onBackButtonPressed = {
                    navController.popBackStack()
                }
            )
        }
    ) {
        Column() {
            SearchFoodWidget(
                onSearchClicked = { navController.navigate(Screen.SearchScreen.route) }
            )
            LazyColumn(
                modifier = Modifier
                    .scrollable(
                        rememberScrollState(),
                        enabled = false,
                        orientation = Orientation.Vertical
                    ),
                contentPadding = PaddingValues(all = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "You have tracked:" + 2,
                            fontSize = 12.sp,
                        textAlign = TextAlign.Start)
                        Text(text = "Show All",
                        fontSize = 12.sp,
                            textAlign = TextAlign.End)
                    }

                }
                items(2){
                    ContentItem(item = SearchFoodItem(
                        1,
                        "Item 1",
                        100f,
                        1f,
                        Units(
                            1,
                            "calories",
                            "cal",
                            "energy"
                        )
                    ), isAdding = false, onAdd = {})
                }
            }


            Column() {
                TabRow(
                    selectedTabIndex = pagerState.currentPage
                ) {
                    tabData.forEachIndexed { index, pair ->
                        Tab(selected = pagerState.currentPage == index, onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }, text = {
                            Text(
                                text = pair,
                                fontSize = 10.sp
                            )
                        })
                    }
                }
            }



            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { index ->
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    if(tabData[index].equals("create food",true)){
                        createFoodOptionList {
                            navController.navigate(Screen.CreateFoodScreen.route)
                        }
                    }else{
                        Text(
                            text = tabData[index],
                        )
                    }

                }
            }





        }



    }

}


enum class CreateOptions{
    Food,
    Recipe,
    Meal
}

@Composable
fun createFoodOptionList(onClick:(CreateOptions)->Unit){
    val listOfOptions = arrayListOf(CreateOptions.Food to "Create Food",CreateOptions.Meal to "Create Meals",CreateOptions.Recipe to "Create Recipes")
    LazyColumn(
    ) {
        items(listOfOptions){option->
            SingleTextAndIconsItem(text = option.second) {
                if(option.first == CreateOptions.Food){
                    onClick(option.first)
                }
            }
        }
    }
}





@Composable
fun SearchFoodWidget(onSearchClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .focusable(false)
            .background(MaterialTheme.colors.primary)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(
            enabled = false,
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .clickable(
                    onClick = onSearchClicked,
                    enabled = true,
                ),
            shape = CircleShape,
            value = "",
            readOnly = true,
            onValueChange = {

            },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(alpha = ContentAlpha.medium),
                    text = "Search here...",
                    style = MaterialTheme.typography.body2
                )
            },
            leadingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(alpha = ContentAlpha.medium),
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        //tint = MaterialTheme.colors.topBarContentColor
                    )
                }
            },
            isError = false,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colors.primaryVariant,
                disabledIndicatorColor = Color.Transparent
            )
        )
        Spacer(Modifier.width(20.dp))
        RoundedIconButton(
            painter = painterResource(id = R.drawable.ic_barcode),
            padding = 8.dp,
            backgroundColor = Color.White,
            onClicked = {

            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMealFoodScreen() {
    ScreenBody {
        SearchFoodWidget {

        }
    }
}