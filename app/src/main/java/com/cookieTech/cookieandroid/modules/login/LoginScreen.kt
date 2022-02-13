package com.cookieTech.cookieandroid.modules.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cookieTech.cookieandroid.R
import com.cookieTech.cookieandroid.modules.login.composable.LoginButton
import com.cookieTech.cookieandroid.navigation.Screen


@Composable
fun LoginScreen(
    navController: NavHostController
) {
    Scaffold() {
        Column(
            Modifier
                .fillMaxSize()
                .padding(all = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {

            LoginButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.Landing.route)
                },
                drawableId = R.drawable.ic_google,
                buttonText = "Continue With Google",
                backGroundColor = Color(0xB3FF3D00),
            )


            Spacer(modifier = Modifier.height(16.dp))
            LoginButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.Landing.route)
                },
                drawableId = R.drawable.ic_facebook,
                buttonText = "Continue With Facebook",
                backGroundColor = Color(0xB3039BE5),
            )

        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLoginScreen() {
    LoginScreen(navController = rememberNavController())
}