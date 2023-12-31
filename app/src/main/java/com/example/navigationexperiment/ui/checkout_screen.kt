package com.example.navigationexperiment.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Minimize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.navigationexperiment.R
import com.example.navigationexperiment.commonUi.AppButton
import com.example.navigationexperiment.commonUi.AppIconButton
import com.example.navigationexperiment.commonUi.SpacerHeight
import com.example.navigationexperiment.commonUi.SpacerWidth
import com.example.navigationexperiment.models.ShoppingBag
import com.example.navigationexperiment.models.shoppingList
import com.example.navigationexperiment.theme.DarkOrange
import com.example.navigationexperiment.theme.GrayColor
import com.example.navigationexperiment.theme.LightGray
import com.example.navigationexperiment.theme.LineColor
import com.example.navigationexperiment.theme.TextColor

@Composable
fun CheckoutScreen(
    navHostController: NavHostController
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AppIconButton(
            icon = Icons.Default.ArrowBack,
            modifier = Modifier.padding(top = 40.dp, start = 20.dp)
        ) {
            navHostController.navigateUp()
        }
        LazyColumn(
            modifier = Modifier.padding(top = 85.dp, bottom = 80.dp)
        ) {
            shoppingBagContent()
        }

        BottomBar(modifier = Modifier.align(Alignment.BottomCenter))

    }

}

fun LazyListScope.shoppingBagContent(

) {
    item {
        Text(
            text = stringResource(R.string.my_shoping_bag), style = TextStyle(
                fontSize = 26.sp,
                fontWeight = FontWeight.W600,
                color = TextColor
            ),
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        SpacerHeight(10.dp)
    }

    items(shoppingList, key = { it.id }) {
        ShoppingItem(shoppingBag = it)
    }
    item {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp), thickness = 5.dp, color = GrayColor
        )
    }
    item {
        RecommendProducts()
    }

}

@Composable
fun ShoppingItem(
    shoppingBag: ShoppingBag
) {
    var count by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = shoppingBag.icon),
                contentDescription = "",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            SpacerWidth()
            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = shoppingBag.title, style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W400,
                            color = TextColor
                        )
                    )
                    CloseButton()

                }
                Text(
                    text = "Qty: ${shoppingBag.qty}", style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        color = LightGray
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {
                        ProductCount(icon = Icons.Default.Minimize) {
                            if (count != "0") count = count.toInt().minus(1).toString()
                        }
                        Text(
                            text = count, style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.W400,
                                color = TextColor,
                            ), modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(horizontal = 15.dp)
                        )
                        ProductCount(icon = Icons.Default.Add) {
                            count = count.toInt().plus(1).toString()
                        }
                    }
                    Text(
                        text = shoppingBag.price, style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W600,
                            color = DarkOrange
                        )
                    )
                }
            }
        }
        SpacerHeight(15.dp)
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = LineColor)
    }
}

@Composable
fun CloseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    Button(
        onClick = { onClick() },
        modifier = modifier.height(24.dp),
        shape = CircleShape,
        border = BorderStroke(
            2.dp,
            DarkOrange
        ),
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    ) {
        Icon(
            Icons.Default.Close,
            contentDescription = "",
            modifier = Modifier.size(10.dp),
            tint = DarkOrange
        )
    }

}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = LineColor)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(0.4f)
            ) {
                Text(
                    text = "Total", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = LightGray
                    )
                )
                Text(
                    text = "$600", style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W600,
                        color = DarkOrange
                    )
                )
            }
            AppButton(
                title = stringResource(R.string.proceed_to_checkout),
                modifier = Modifier.width(216.dp)
            )
        }
    }
}