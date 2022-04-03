package com.cookieTech.cookieandroid.modules.mealFood

import android.text.Editable
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cookieTech.cookieandroid.R
import com.cookieTech.cookieandroid.core.widget.RoundedIconButton
import com.cookieTech.cookieandroid.core.base.ScreenBody
import com.cookieTech.cookieandroid.core.widget.DefaultTopBar
import com.cookieTech.cookieandroid.navigation.Screen


@Composable
fun MealFoodScreen(navController: NavHostController) {
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
            SearchFoodWidget(false,{
                Log.d("serch_test", "MealFoodScreen: ")
                navController.navigate(Screen.SearchScreen.route)
            })
        }

    }

}

@Composable
fun SearchFoodWidget(isEditable:Boolean,onSearchClicked:()->Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(
            enabled= isEditable,
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .clickable(
                    onClick = onSearchClicked,
                    enabled = true,
                ),
            shape = CircleShape,
            value = "",
            readOnly = !isEditable,
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
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.White,
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
        SearchFoodWidget(false,{

        })
    }
}