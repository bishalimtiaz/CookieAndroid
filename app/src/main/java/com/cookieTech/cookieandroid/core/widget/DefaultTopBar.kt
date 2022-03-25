package com.cookieTech.cookieandroid.core.widget

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.cookieTech.cookieandroid.ui.theme.topBarContentColor

@Composable
fun DefaultTopBar(
    elevation: Dp = AppBarDefaults.TopAppBarElevation,
    title: String,
    onBackButtonPressed: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(
                text = title,
            )
        },
        navigationIcon = if (onBackButtonPressed != null) {
            {
                IconButton(
                    modifier = Modifier
                        .alpha(alpha = ContentAlpha.medium),
                    onClick = {
                        onBackButtonPressed()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Icon",
                        tint = topBarContentColor
                    )
                }
            }
        } else null,
        actions = {},
        elevation = elevation
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewDefaultTopBar() {
    DefaultTopBar(
        title = "Home"
    )
}