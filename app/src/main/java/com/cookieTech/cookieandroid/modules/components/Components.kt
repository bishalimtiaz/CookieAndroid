package com.cookieTech.cookieandroid.modules

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cookieTech.cookieandroid.R
import com.cookieTech.cookieandroid.core.widget.RoundedIconButton
import com.cookieTech.cookieandroid.domain.models.SearchFoodItem
import com.cookieTech.cookieandroid.domain.models.Units

@Composable
fun ContentItem(item: SearchFoodItem, isAdding:Boolean, onAdd:(item: SearchFoodItem)->Unit) {
    Surface(modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = item.foodName,style = MaterialTheme.typography.subtitle1)
                Text(text = "${item.quantity}  ${item.unit!!.unit_symbol}",style = MaterialTheme.typography.body2)
            }
            RoundedIconButton(
                onClicked = { onAdd(item) },
                painter = if(isAdding){
                    painterResource(id = R.drawable.ic_plus)
                } else painterResource(id = R.drawable.ic_cross)


            )
        }
    }
}


@Composable
fun SingleTextAndIconsItem(
    text:String,
    icon:Int = 0,
    contentDescription:String = "image",
    onClick:()->Unit
) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick() }
    ) {

        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(text = text,style = MaterialTheme.typography.subtitle1)
            }
            if(icon != 0){
                Image(painter = painterResource(id = icon), contentDescription =contentDescription)
            }

        }
        Divider()
    }
}


@Composable
@Preview(showBackground = true)
fun previewContentItem(){
    ContentItem(
        item = SearchFoodItem(
            1,
            "Apple",
            1f,
            1f,
            Units(1, "kilo calorie", "kcal", "energy")
        ),true,{

        }
    )
}

@Composable
@Preview(showBackground = true)
fun previewContentItemWithCross(){
    ContentItem(
        item = SearchFoodItem(
            1,
            "Apple",
            1f,
            1f,
            Units(1, "kilo calorie", "kcal", "energy")
        ),false,{

        }
    )
}

@Composable
@Preview(showBackground = true)
fun previewSingleTextAndIconsItem(){
    SingleTextAndIconsItem("Something") {


    }
}