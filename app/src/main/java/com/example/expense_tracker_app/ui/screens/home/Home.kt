package com.example.expense_tracker_app.ui.screens.home

import ScrollableRecentActivityList
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expense_tracker_app.data.ActivityCardData
import com.example.expense_tracker_app.ui.composable.home.ProfileCompletion
import com.example.expense_tracker_app.ui.composable.home.RowScrollView
import com.example.expense_tracker_app.ui.composable.home.UserInfo
import com.example.expense_tracker_app.ui.composable.home.Wallet
import com.example.expense_tracker_app.ui.theme.ExpensetrackerappTheme

@Composable
fun Home(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(8.dp)
  ) {
    UserInfo()
    Wallet()
    ActivitiesCategoryRow()
    ProfileCompletion()
    ScrollableRecentActivityList()
  }
}

@Composable
fun ActivitiesCategoryRow() {
  Row(
    modifier = Modifier
      .padding(horizontal = 10.dp)
      .horizontalScroll(rememberScrollState()),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
  ){
    RowScrollView(
      items = ActivityCardData,
      maxCharacters = 10,
      modifier = Modifier
        .fillMaxWidth()
    )
  }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
  ExpensetrackerappTheme {
    Home()
  }
}