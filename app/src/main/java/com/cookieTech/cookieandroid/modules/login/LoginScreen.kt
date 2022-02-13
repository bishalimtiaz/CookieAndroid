package com.cookieTech.cookieandroid.modules.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cookieTech.cookieandroid.R
import com.cookieTech.cookieandroid.modules.login.composable.LoginButton


@Composable
fun LoginScreen(
    navController: NavController
) {
    Scaffold() {
        Column(
            Modifier
                .fillMaxSize()
                .padding(all = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {

            LoginButton(
                onClick = { /*TODO*/ },
                drawableId = R.drawable.ic_google,
                buttonText = "Continue With Google",
                backGroundColor = Color(0xB3FF3D00),
            )


            Spacer(modifier = Modifier.height(16.dp))
            LoginButton(
                onClick = { /*TODO*/ },
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