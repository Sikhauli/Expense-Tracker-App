package com.example.expense_tracker_app.ui.navigationMap

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expense_tracker_app.ui.MainScreen
import com.example.expense_tracker_app.ui.screens.activity.ActivityPageMain

@Composable
fun NavigationMap() {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = "home") {
    composable("home") { MainScreen(navController) }
    composable("details/{itemId}") { backStackEntry ->
      val itemId = backStackEntry.arguments?.getString("itemId")
      ActivityPageMain(itemId)
    }
  }
}