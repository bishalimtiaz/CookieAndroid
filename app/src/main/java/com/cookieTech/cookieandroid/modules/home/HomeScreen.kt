package com.cookieTech.cookieandroid.modules.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cookieTech.cookieandroid.R
import com.cookieTech.cookieandroid.core.base.ScreenBody
import com.cookieTech.cookieandroid.modules.home.composable.AddMealItem

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    HomeContent()
}


@Composable
fun HomeContent() {
    ScreenBody {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            AddDailyActivitySection()
        }
    }
}

@Composable
fun AddDailyActivitySection(){
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AddMealItem(
            painter = painterResource(id = R.drawable.ic_breakfast),
            title = "Add Breakfast",
            subTitle = "Recommended 500-600 kcal"
        )
        AddMealItem(
            painter = painterResource(id = R.drawable.ic_lunch),
            title = "Add Lunch",
            subTitle = "Recommended 760-1040 kcal"
        )
        AddMealItem(
            painter = painterResource(id = R.drawable.ic_dinner),
            title = "Add Dinner",
            subTitle = "Recommended 760-1040 kcal"
        )
        AddMealItem(
            painter = painterResource(id = R.drawable.ic_snacks),
            title = "Add Snack",
            subTitle = "Recommended 127-253 kcal"
        )
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen() {
    HomeContent()
}