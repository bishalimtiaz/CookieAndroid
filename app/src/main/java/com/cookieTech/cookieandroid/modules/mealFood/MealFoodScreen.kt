package com.cookieTech.cookieandroid.modules.mealFood

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.cookieTech.cookieandroid.core.base.ScreenBody

@Composable
fun MealFoodScreen(
    navController: NavHostController
){
    MealFoodContent()
}

@Composable
fun MealFoodContent(){
    ScreenBody {
        Text(text = "Meal Food Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMealFOod(){
    MealFoodContent()
}