package com.example.expense_tracker_app.ui.navigationMap

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expense_tracker_app.data.ActivityCard
import com.example.expense_tracker_app.ui.MainScreen
import com.example.expense_tracker_app.ui.screens.activity.ActivityPageMain
import com.example.expense_tracker_app.viewModel.BottomSheetViewModel

@Composable
fun NavigationMap() {
  val navController = rememberNavController()
  val bottomSheetViewModel: BottomSheetViewModel = hiltViewModel()
  NavHost(navController = navController, startDestination = "home") {
    composable("home") { MainScreen(navController) }
    composable("details") { backStackEntry ->
      val activityCard = backStackEntry.arguments?.getParcelable<ActivityCard>("activityCard")
      ActivityPageMain(bottomSheetViewModel, navController, activityCard)
    }
  }
}