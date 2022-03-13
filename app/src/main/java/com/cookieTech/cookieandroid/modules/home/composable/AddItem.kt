package com.cookieTech.cookieandroid.modules.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cookieTech.cookieandroid.R

@Composable
fun AddMealItem(
    painter: Painter,
    title: String,
    subTitle: String,
    onAddItemClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = Color.White,
        elevation = 4.dp,
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painter,
                contentDescription = "Meal Icon",
            )

            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1

                )
                Text(
                    text = subTitle,
                    style = MaterialTheme.typography.body2,
                    maxLines = 1
                )

            }
            RoundedAddButton(
                onClicked = onAddItemClicked
            )

        }

    }
}


@Composable
@Preview(showBackground = true)
fun PreviewAddItem(){
    AddMealItem(
        painter = painterResource(id = R.drawable.ic_snacks),
        title = "Add Snacks", subTitle = "Recommended 127-253 kcal",
        onAddItemClicked = {}
    )
}