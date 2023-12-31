package com.example.navigationexperiment.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Minimize
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.navigationexperiment.R
import com.example.navigationexperiment.commonUi.AppButton
import com.example.navigationexperiment.commonUi.AppIconButtonDrawable
import com.example.navigationexperiment.commonUi.AppIconDrawable
import com.example.navigationexperiment.commonUi.SpacerHeight
import com.example.navigationexperiment.commonUi.SpacerWidth
import com.example.navigationexperiment.models.popularProductList
import com.example.navigationexperiment.navigation.Routes
import com.example.navigationexperiment.theme.Background
import com.example.navigationexperiment.theme.DarkOrange
import com.example.navigationexperiment.theme.GrayColor
import com.example.navigationexperiment.theme.LightGray
import com.example.navigationexperiment.theme.LightOrange
import com.example.navigationexperiment.theme.LineColor
import com.example.navigationexperiment.theme.TextColor
import com.example.navigationexperiment.theme.Yellow
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun ProductDetailScreen(
    navHostController: NavHostController
) {

    val chipList = listOf("Description", "Material", "Review")
    var selected by remember { mutableStateOf("Description") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.product_four),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            )
            HeaderIcon(navHostController)
            Card(
                modifier = Modifier
                    .padding(top = 230.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.padding(bottom = 70.dp)
                ) {
                    item {
                        ProductHeaderSection()
                    }
                    item {
                        RatingSection()
                    }
                    item {
                        FlowRow(
                            modifier = Modifier.padding(vertical = 15.dp)
                        ) {
                            chipList.forEach {
                                CustomChip(title = it, selected = it == selected) { data ->
                                    selected = data
                                }
                            }
                        }
                        Text(
                            text = stringResource(R.string.description), style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400,
                                color = LightGray
                            ),
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                        SpacerHeight(15.dp)
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = GrayColor,
                            thickness = 5.dp
                        )
                    }
                    item {
                        RecommendProducts()
                    }
                }

            }

        }
        BottomBarItem(
            modifier = Modifier.align(BottomCenter),
            navHostController
        )
    }

}

@Composable
fun RecommendProducts() {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Text(
            text = stringResource(R.string.recommend_products), style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                color = TextColor
            )
        )
        LazyRow {
            item {
                SpacerWidth()
            }
            items(popularProductList) {
                PopularProductGridView(
                    popularProducts = it,
                    modifier = Modifier.padding(end = 10.dp, top = 15.dp)
                )
            }
        }
    }
}

@Composable
fun ProductHeaderSection() {
    var count by remember { mutableStateOf("0") }
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Text(
            text = stringResource(R.string.product_name), style = TextStyle(
                color = TextColor,
                fontWeight = FontWeight.W400,
                fontSize = 20.sp,
            )
        )
        SpacerHeight(10.dp)
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$599", style = TextStyle(
                    fontSize = 20.sp, fontWeight = FontWeight.W600, color = DarkOrange
                )
            )
            Row(
            ) {
                ProductCount(icon = Icons.Default.Minimize) {
                    if (count != "0") count = count.toInt().minus(1).toString()
                }
                Text(
                    text = count, style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        color = TextColor,
                    ), modifier = Modifier
                        .align(CenterVertically)
                        .padding(horizontal = 15.dp)
                )
                ProductCount(icon = Icons.Default.Add) {
                    count = count.toInt().plus(1).toString()
                }
            }
        }
    }
}

@Composable
fun RatingSection() {

    val personIcons =
        listOf(R.drawable.person_1, R.drawable.person_2, R.drawable.person_3, R.drawable.person_4)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Row {
                    Row {
                        (0..4).forEach {
                            Icon(
                                Icons.Default.StarRate,
                                contentDescription = "",
                                tint = Yellow,
                            )
                        }
                    }
                    SpacerWidth(10.dp)
                    Text(
                        text = "5.0", style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W400,
                            color = TextColor
                        ),
                        modifier = Modifier.align(CenterVertically)
                    )
                }
                Row(
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    Text(
                        text = "98 Reviews", style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W400,
                            color = LightGray
                        ),
                        modifier = Modifier.align(CenterVertically)
                    )
                    SpacerWidth()
                    Icon(
                        Icons.Default.KeyboardArrowRight,
                        contentDescription = "",
                        tint = LightGray
                    )
                }
            }
            Row(
                modifier = Modifier.align(CenterVertically)
            ) {
                personIcons.forEachIndexed { index, i ->
                    Log.d("main", "RatingSection: $index ")
                    AppIconDrawable(
                        icon = i,
                        modifier = Modifier
                            .size(32.dp)
                            .offset(
                                x = if (index > 0) -(10.dp) else 0.dp, y = 0.dp
                            ),
                    )
                }

            }
        }
    }
}

@Composable
fun CustomChip(
    title: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    TextButton(
        onClick = { onValueChange(title) },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (selected) LightOrange else Color.Transparent
        ),
        elevation = ButtonDefaults.elevation(0.dp),
        modifier = modifier.padding(start = 20.dp)
    ) {
        Text(
            text = title, style = TextStyle(
                color = if (selected) DarkOrange else LightGray,
                fontWeight = if (selected) FontWeight.W600 else FontWeight.W400,
                fontSize = if (selected) 16.sp else 14.sp
            )
        )
    }
}


@Composable
fun BottomBarItem(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Divider(modifier = Modifier.fillMaxWidth(), color = LineColor)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            TextButton(
                onClick = { },
                modifier = Modifier
                    .size(40.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = ButtonDefaults.elevation(0.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                border = BorderStroke(1.dp, LightGray)
            ) {
                Icon(
                    Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    tint = LightGray,
                    modifier = Modifier.size(16.dp)
                )
            }
            SpacerWidth(10.dp)
            AppButton(
                title = stringResource(R.string.add_to_ba),
                modifier = Modifier.weight(0.7f)
            ) {
                navHostController.navigate(Routes.CheckoutScreen)
            }
        }
    }

}


@Composable
fun ProductCount(
    icon: ImageVector, modifier: Modifier = Modifier, onClick: () -> Unit = {}
) {
    TextButton(
        onClick = { onClick() },
        modifier = modifier.size(24.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        border = BorderStroke(2.dp, DarkOrange)
    ) {
        Icon(icon, contentDescription = "", tint = DarkOrange)
    }
}

@Composable
fun HeaderIcon(
    navHostController: NavHostController
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AppIconButtonDrawable(icon = R.drawable.back) {
            navHostController.navigateUp()
        }
        AppIconButtonDrawable(icon = R.drawable.share)
    }

}


