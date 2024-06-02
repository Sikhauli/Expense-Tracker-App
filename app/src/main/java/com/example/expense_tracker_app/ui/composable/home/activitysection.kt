package com.example.expense_tracker_app.ui.composable.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.expense_tracker_app.data.ActivityCard
import com.example.expense_tracker_app.ui.screens.home.Home
import com.example.expense_tracker_app.ui.theme.ExpensetrackerappTheme
import com.example.expense_tracker_app.ui.utils.LimitedText
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage

@Composable
fun RowItems(
  navController: NavHostController,
  modifier: Modifier = Modifier,
  item: ActivityCard,
  maxCharacters: Int = 10,
) {

  val gradientBrush = Brush.linearGradient(
    colors = listOf(Color.Magenta, Color.Cyan),
    tileMode = TileMode.Clamp
  )

  Box(
    modifier = modifier
      .fillMaxWidth()
      .clickable {
        navController.navigate("details/${item.id}")
      }
  ) {
    Column(
      modifier = Modifier
        .size(100.dp, 100.dp)
        .border(1.dp, Color.LightGray, shape = RoundedCornerShape(5.dp)),
      verticalArrangement = Arrangement.Top,
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(5.dp)
      ) {

        Column(
          modifier = Modifier
            .size(30.dp)
            .background(brush = gradientBrush,  shape = RoundedCornerShape(10.dp)),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          CoilImage(
            imageModel = { item.img },
            imageOptions = ImageOptions(
              contentScale = ContentScale.Crop,
              alignment = Alignment.Center,
            ),
            modifier = Modifier
              .size(20.dp)
          )
        }
        LimitedText(
          text = item.activityName,
          maxCharacters = maxCharacters
        )
        Row {
          Text(
            text = item.availableAmount.toString(),
            fontSize = 8.sp,
            fontFamily = FontFamily.Serif,
            style = MaterialTheme.typography.titleSmall
          )
          Text(
            text = " / ",
            fontSize = 12.sp,
            fontFamily = FontFamily.Serif,
            style = MaterialTheme.typography.titleSmall
          )
          Text(
            text = item.budget.toString(),
            fontSize = 8.sp,
            fontFamily = FontFamily.Serif,
            style = MaterialTheme.typography.titleSmall
          )
        }
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
          horizontalArrangement = Arrangement.End,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "Details",
            fontSize = 8.sp,
            fontFamily = FontFamily.Serif,
            style = MaterialTheme.typography.bodyLarge
          )
          Icon(
            Icons.Rounded.Info,
            contentDescription = "Localized description",
            tint = MaterialTheme.colorScheme.inverseSurface
            )
        }
      }
    }
  }
}

@Composable
fun RowScrollView(
  navController : NavHostController,
  modifier: Modifier = Modifier,
  items: List<ActivityCard>,
  maxCharacters: Int = 10,
) {
  items.forEach { item ->
    RowItems(
      item = item,
      navController = navController,
      maxCharacters = maxCharacters
    )
  }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
  ExpensetrackerappTheme {
//    Home(navController)
  }
}
