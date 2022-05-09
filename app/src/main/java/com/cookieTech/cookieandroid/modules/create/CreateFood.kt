package com.cookieTech.cookieandroid.modules.create

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cookieTech.cookieandroid.core.base.ScreenBody
import com.cookieTech.cookieandroid.core.widget.DefaultTopBar
import com.cookieTech.cookieandroid.modules.home.AddDailyActivitySection
import com.cookieTech.cookieandroid.navigation.Screen

@Composable
fun CreateFoodScreen(navController: NavHostController) {
    ScreenBody(
        topBar = {
            DefaultTopBar(
                title = "Create Food",
                onBackButtonPressed = {navController.navigateUp()},
                actions = {
                    Log.d("create_food", "CreateFoodScreen: ")
                }
            )
        }
    ) {

    }
}
