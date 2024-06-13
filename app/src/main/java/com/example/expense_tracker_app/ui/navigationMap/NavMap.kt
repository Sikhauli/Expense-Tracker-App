package com.example.expense_tracker_app.ui.navigationMap

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expense_tracker_app.ui.MainScreen
import com.example.expense_tracker_app.ui.screens.activity.ActivityPageMain
import com.example.expense_tracker_app.viewModel.BottomSheetViewModel
import com.example.expense_tracker_app.viewModel.HomeViewModal

@Composable
fun NavigationMap() {
  val navController = rememberNavController()
  val bottomSheetViewModel: BottomSheetViewModel = hiltViewModel()
  val homeViewModel: HomeViewModal = viewModel()
  NavHost(navController = navController, startDestination = "home") {
    composable("home") { MainScreen(navController, homeViewModel) }
    composable("details/{itemId}") { backStackEntry ->
      val itemId = backStackEntry.arguments?.getString("itemId")
      if (itemId != null) {
        ActivityPageMain(bottomSheetViewModel, navController, itemId)
      }
    }
  }
}