package com.example.navigationexperiment.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.core.FeatureScreenARouteContract
import com.example.navigationexperiment.R
import com.example.navigationexperiment.commonUi.SpacerHeight
import com.example.navigationexperiment.commonUi.SpacerWidth
import com.example.navigationexperiment.models.Category
import com.example.navigationexperiment.models.PopularProducts
import com.example.navigationexperiment.models.Rooms
import com.example.navigationexperiment.models.categoryList
import com.example.navigationexperiment.models.popularProductList
import com.example.navigationexperiment.models.roomList
import com.example.navigationexperiment.navigation.Routes
import com.example.navigationexperiment.theme.DarkOrange
import com.example.navigationexperiment.theme.LightGray
import com.example.navigationexperiment.theme.PoppinFont
import com.example.navigationexperiment.theme.TextColor
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    featureScreenARouteContract: FeatureScreenARouteContract
) {
    var search by remember { mutableStateOf("") }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        item {
            HomeHeader()
        }
        item {
            CustomSearchView(text = search) {
                search = it
            }
        }
        item {
            CategoryRow(navHostController,featureScreenARouteContract)
        }
        item {
            SpacerHeight(20.dp)
            ProductRow(navHostController,featureScreenARouteContract)
        }
        item {
            Banner()
        }
        item {
            RoomsHeader()
        }

    }
}


@Composable
fun CategoryRow(
navHostController: NavHostController,
featureScreenARouteContract: FeatureScreenARouteContract

) {

    Column {
        CommonTitle(title = stringResource(R.string.categories),navHostController,featureScreenARouteContract)
        SpacerHeight(20.dp)
        LazyRow {
            items(categoryList, key = { it.id }) {
                CategoryEachRow(category = it)
            }
        }
    }

}

@Composable
fun ProductRow(
    navHostController: NavHostController,
    featureScreenARouteContract: FeatureScreenARouteContract

) {
    Column {
        CommonTitle(title = stringResource(R.string.popular),navHostController,featureScreenARouteContract)
        SpacerHeight(20.dp)

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            mainAxisSpacing = 10.dp,
            mainAxisAlignment = MainAxisAlignment.SpaceEvenly
        ) {
            popularProductList.forEach {
                PopularProductGridView(it) {
                    navHostController.navigate(Routes.ProductScreen)
                }
            }
        }
    }
}

@Composable
fun RoomsHeader() {
    Column {
        Text(
            text = stringResource(R.string.rooms), style = TextStyle(
                color = TextColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.W600,
                fontFamily = PoppinFont,
            )
        )
        SpacerHeight(5.dp)
        Text(
            text = stringResource(R.string.room_des), style = TextStyle(
                color = LightGray,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                fontFamily = PoppinFont,
            )
        )
        SpacerHeight(10.dp)
        LazyRow {
            items(roomList, key = { it.id }) {
                RoomSection(rooms = it)
            }
        }
    }
}

@Composable
fun Banner() {
    Image(
        painter = painterResource(id = R.drawable.banner), contentDescription = "",
        modifier = Modifier
            .padding(vertical = 20.dp)
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .height(113.dp),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun PopularProductGridView(
    popularProducts: PopularProducts,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}

) {

    Box(
        modifier = modifier
            .height(208.dp)
            .clickable { onClick() }
    ) {
        Card(
            modifier = Modifier
                .width(150.dp)
                .height(155.dp)
                .align(BottomCenter),
            shape = RoundedCornerShape(8.dp),
        ) {
            Box {
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                        .align(BottomStart)
                ) {
                    Text(
                        text = popularProducts.title, style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = PoppinFont,
                            color = LightGray
                        )
                    )
                    Text(
                        text = popularProducts.price, style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W600,
                            fontFamily = PoppinFont,
                            color = TextColor
                        )
                    )
                }
            }
        }
        Box {
            Image(
                painter = painterResource(id = popularProducts.image),
                contentDescription = "",
                modifier = Modifier
                    .width(141.dp)
                    .height(149.dp)
                    .padding(horizontal = 15.dp)
                    .offset(0.dp, (-5).dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.wishlist), contentDescription = "",
                modifier = Modifier
                    .padding(20.dp)
                    .size(32.dp)
                    .align(TopEnd),
                tint = Color.Unspecified
            )
        }

    }

}

@Composable
fun CommonTitle(
    title: String, navHostController: NavHostController,
    featureScreenARouteContract: FeatureScreenARouteContract
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = title, style = TextStyle(
                color = TextColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.W600,
                fontFamily = PoppinFont,
                textAlign = TextAlign.Center
            ), modifier = Modifier.align(CenterVertically)
        )
        TextButton(onClick = {//Scenario when navigating to diff module)
            featureScreenARouteContract.show("passing from main",navHostController) }){
            Text(
                text = stringResource(R.string.see_all), style = TextStyle(
                    color = DarkOrange,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = PoppinFont,
                    textAlign = TextAlign.Center
                )
            )
            SpacerWidth(3.dp)
            Icon(Icons.Default.ArrowForward, contentDescription = "", tint = DarkOrange)
        }
    }
}

@Composable
fun CategoryEachRow(
    category: Category
) {
    Box(
        modifier = Modifier
            .padding(end = 15.dp)
            .width(140.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(category.color)
    ) {
        Text(
            text = category.title, style = TextStyle(
                color = TextColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                fontFamily = PoppinFont
            ), modifier = Modifier
                .align(CenterStart)
                .padding(start = 10.dp)
        )
        Image(
            painter = painterResource(id = category.image),
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .align(BottomEnd)
                .padding(end = 5.dp)
        )
    }
}

@Composable
fun CustomSearchView(
    text: String, onValueChange: (String) -> Unit
) {
    Card(
        elevation = 0.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        border = BorderStroke(1.dp, LightGray)
    ) {
        TextField(value = text,
            onValueChange = { onValueChange(it) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = TextColor,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = stringResource(R.string.placeholder), style = TextStyle(
                        color = LightGray,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W400,
                        fontFamily = PoppinFont,
                        textAlign = TextAlign.Center
                    )
                )
            },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "", tint = LightGray) })
    }
}

@Composable
fun HomeHeader(
    onClick: () -> Unit = {}
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.heading_text), style = TextStyle(
                color = TextColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.W600,
                fontFamily = PoppinFont
            )
        )
        IconButton(
            onClick = { onClick() }, modifier = Modifier
                .size(32.dp)
                .align(CenterVertically)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.notification),
                contentDescription = "",
                tint = DarkOrange
            )
        }
    }

}

@Composable
fun RoomSection(
    rooms: Rooms
) {
    Box(
        modifier = Modifier.padding(end = 15.dp)
    ) {
        Image(
            painter = painterResource(id = rooms.image),
            contentDescription = rooms.title,
            modifier = Modifier
                .width(127.dp)
                .height(195.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            text = rooms.title, style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = TextColor
            ), modifier = Modifier
                .width(100.dp)
                .padding(20.dp)
        )
    }
}