package com.example.expense_tracker_app.ui.screens.activity

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.expense_tracker_app.data.ActivityCard
import com.example.expense_tracker_app.ui.composable.activity.ActivityPage
import com.example.expense_tracker_app.viewModel.BottomSheetViewModel

@Composable
fun ActivityPageMain(bottomSheetViewModel: BottomSheetViewModel, navController: NavController?, itemId: String) {
  ActivityPage(bottomSheetViewModel, navController, itemId)
}