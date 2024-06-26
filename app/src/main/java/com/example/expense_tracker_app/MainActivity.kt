package com.example.expense_tracker_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.expense_tracker_app.ui.navigationMap.NavigationMap
import com.example.expense_tracker_app.ui.theme.ExpensetrackerappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      ExpensetrackerappTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          NavigationMap()
        }
      }
    }
  }
}


//@Composable
//fun MainContent(homeViewModel: HomeViewModal = viewModel()) {
//  LaunchedEffect(Unit) {
//    homeViewModel.populateDatabase()
//  }
//  NavigationMap()
//}
