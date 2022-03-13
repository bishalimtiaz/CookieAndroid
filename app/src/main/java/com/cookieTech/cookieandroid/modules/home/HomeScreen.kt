package com.cookieTech.cookieandroid.modules.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cookieTech.cookieandroid.R
import com.cookieTech.cookieandroid.core.base.BaseScreen
import com.cookieTech.cookieandroid.modules.home.composable.AddMealItem
import com.cookieTech.cookieandroid.navigation.Screen

class HomeScreen(val navController: NavHostController) : BaseScreen() {
    @Composable
    override fun Body() {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            AddDailyActivitySection()
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
                subTitle = "Recommended 500-600 kcal",
                onAddItemClicked = {
                    navigateToMealFoodScreen()
                }
            )
            AddMealItem(
                painter = painterResource(id = R.drawable.ic_lunch),
                title = "Add Lunch",
                subTitle = "Recommended 760-1040 kcal",
                onAddItemClicked = {
                    navigateToMealFoodScreen()
                }
            )
            AddMealItem(
                painter = painterResource(id = R.drawable.ic_dinner),
                title = "Add Dinner",
                subTitle = "Recommended 760-1040 kcal",
                onAddItemClicked = {
                    navigateToMealFoodScreen()
                }
            )
            AddMealItem(
                painter = painterResource(id = R.drawable.ic_snacks),
                title = "Add Snack",
                subTitle = "Recommended 127-253 kcal",
                onAddItemClicked = {
                    navigateToMealFoodScreen()
                }
            )
        }
    }

    private fun navigateToMealFoodScreen(){
        navController.navigate(Screen.MealFood.route)
    }


}