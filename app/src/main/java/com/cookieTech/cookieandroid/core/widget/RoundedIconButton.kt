package com.cookieTech.cookieandroid.core.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cookieTech.cookieandroid.R

@Composable
fun RoundedIconButton(
    backgroundColor: Color = Color(0xFFEEEEEE),
    padding: Dp = 4.dp,
    painter: Painter,
    onClicked: () -> Unit
){
    Surface(
        shape = CircleShape,
        color = backgroundColor,
        modifier = Modifier
            .clickable { onClicked() }
    ) {
        Image(
            modifier = Modifier.padding(padding),
            painter = painter,
            contentDescription = "Butt icon"
        )

    }
}

@Preview
@Composable
fun PreviewRoundedAddButton(){
    RoundedIconButton(
        onClicked = {},
        painter = painterResource(id = R.drawable.ic_plus),
    )
}