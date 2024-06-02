package com.example.expense_tracker_app.ui.composable.activity

import ScrollableRecentActivityList
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expense_tracker_app.ui.theme.ExpensetrackerappTheme

@Composable
fun ActivityPage(itemId: String?) {

  val activityName = "Car Fuel"
  val amount = 240

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ){
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ){
    Text(
      text = "ACTIVITY",
      fontWeight = FontWeight.Bold,
      fontFamily = FontFamily.Serif,
      style = MaterialTheme.typography.titleLarge
    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(
      text = "$activityName Wallet",
      fontWeight = FontWeight.W400,
      fontFamily = FontFamily.Serif,
      style = MaterialTheme.typography.titleMedium
    )
    Text(
      text = "R$amount",
      fontSize = 70.sp,
      fontWeight = FontWeight.ExtraBold,
      fontFamily = FontFamily.Serif,
      style = MaterialTheme.typography.titleLarge
    )
    Text(
      text = "Budget in one month R$amount",
      fontFamily = FontFamily.Serif,
      fontWeight = FontWeight.W300,
    )
    }

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 26.dp, bottom = 10.dp),
      verticalArrangement = Arrangement.Center,
    ) {
      Text(
        text = "Spending Activity",
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W800,
      )
    }
    Column(
      modifier = Modifier
        .fillMaxWidth(),
      verticalArrangement = Arrangement.Center,
    ){
      Text(
        text = "Wallet Details",
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W800,
        modifier = Modifier.padding(vertical = 6.dp)
      )
      Text(
        text = "A wallet to manage expenses for purchasing $activityName in one month",
        fontFamily = FontFamily.Serif,
        fontSize = 12.sp,
        style = MaterialTheme.typography.displaySmall.copy(
          lineHeight = 14.sp
        ),
      )
    }
    Spacer(modifier = Modifier.height(10.dp))
    ScrollableRecentActivityList()
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ActivityPagePreview() {
  ExpensetrackerappTheme {
//    ActivityPage(itemId)
  }
}



