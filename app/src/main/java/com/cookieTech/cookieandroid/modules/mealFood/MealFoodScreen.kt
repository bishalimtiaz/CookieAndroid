package com.cookieTech.cookieandroid.modules.mealFood

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.cookieTech.cookieandroid.core.base.BaseScreen


class MealFoodScreen(navController: NavHostController) : BaseScreen() {

    @Composable
    override fun Body() {
        Column() {

        }
    }

    @Composable
    private fun SearchView(){
        Box(
            modifier = Modifier.fillMaxWidth()
        ){

        }
    }

}