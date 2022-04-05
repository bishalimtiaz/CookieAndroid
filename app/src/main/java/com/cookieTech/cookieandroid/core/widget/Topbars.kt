package com.cookieTech.cookieandroid.core.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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

@Composable
fun SearchTopBar(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onBackClicked: () -> Unit
) {

    /**
     * Auto Focus
     * **/
    val focusRequester = remember {
        FocusRequester()
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }



    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .semantics {
                contentDescription = "SearchWidget"
            },
        elevation = AppBarDefaults.TopAppBarElevation
    ) {
        TextField(
            modifier = Modifier
                .focusRequester(focusRequester)
                .fillMaxWidth()
                .semantics {
                    contentDescription = "TextField"
                },
            value = text,
            onValueChange = { onTextChange(it) },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(alpha = ContentAlpha.medium),
                    text = "Search here...",
                    style = MaterialTheme.typography.body2
                )
            },
            textStyle = MaterialTheme.typography.subtitle2,
            singleLine = true,
            leadingIcon = {
                BackButton(onTap = onBackClicked)
            },
            trailingIcon = {
                if (text.isNotEmpty()) ClearButton(onTap = onCloseClicked)
            },
            keyboardOptions = KeyboardOptions(
                imeAction = androidx.compose.ui.text.input.ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                cursorColor = MaterialTheme.colors.primaryVariant
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewDefaultTopBar() {
    DefaultTopBar(
        title = "Home"
    )
}

@Composable
fun BackButton(onTap: () -> Unit) {
    IconButton(
        modifier = Modifier
            .alpha(alpha = ContentAlpha.medium),
        onClick = onTap
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back Icon",
            tint = Color.Black
        )
    }
}

@Composable
fun ClearButton(onTap: () -> Unit) {
    IconButton(
        modifier = Modifier
            .semantics {
                contentDescription = "CloseButton"
            },
        onClick = onTap
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close Icon",
            tint = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchTopBAr() {
    SearchTopBar(
        text = "Home",
        {},
        {},
        {},
        {}
    )
}