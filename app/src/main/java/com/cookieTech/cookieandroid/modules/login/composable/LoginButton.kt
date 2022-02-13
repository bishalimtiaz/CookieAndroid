package com.cookieTech.cookieandroid.modules.login.composable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginButton(
    onClick: () -> Unit,
    @DrawableRes
    drawableId: Int,
    buttonText: String,
    backGroundColor: Color,

){
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = backGroundColor),
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = drawableId),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 8.dp)
            )
            Text(
                text = buttonText,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )

        }
    }

}

@Composable
@Preview
fun PreviewLoginButton(){

}