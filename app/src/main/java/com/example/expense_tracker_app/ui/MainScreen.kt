package com.example.expense_tracker_app.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.expense_tracker_app.ui.screens.home.Home

@Composable
fun MainScreen() {
  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Home(modifier = Modifier.padding(innerPadding))
  }
}