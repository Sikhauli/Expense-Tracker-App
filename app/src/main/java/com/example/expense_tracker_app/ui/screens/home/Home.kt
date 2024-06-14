package com.example.expense_tracker_app.ui.screens.home

import ScrollableRecentActivityList
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.expense_tracker_app.ui.composable.home.ProfileCompletion
import com.example.expense_tracker_app.ui.composable.home.RowScrollView
import com.example.expense_tracker_app.ui.composable.home.UserInfo
import com.example.expense_tracker_app.ui.composable.home.Wallet
import com.example.expense_tracker_app.viewModel.HomeViewModal

@Composable
fun Home(modifier: Modifier = Modifier, navController: NavHostController, homeViewModel: HomeViewModal ) {

  val allBudgets by homeViewModel.allBudgets.collectAsState()

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(8.dp)
  ) {
    UserInfo()
    Wallet()
    ActivitiesCategoryRow(navController, homeViewModel)
    ProfileCompletion()
    ScrollableRecentActivityList(
      allBudgets,
    )
  }
}


@Composable
fun ActivitiesCategoryRow(navController: NavHostController, homeViewModel: HomeViewModal) {
  LaunchedEffect(Unit) {
    homeViewModel.getAllActivityCards()
  }
  val cardsData by homeViewModel.activityCards.observeAsState(initial = emptyList())
  Row(
    modifier = Modifier
      .padding(vertical = 10.dp)
      .horizontalScroll(rememberScrollState()),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
  ){
    RowScrollView(
      navController = navController,
      items = cardsData,
      maxCharacters = 10
    )
  }
}