package com.example.expense_tracker_app.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BottomSheetViewModel : ViewModel() {
  private val _showBottomSheet = MutableStateFlow(false)
  val showBottomSheet: StateFlow<Boolean> = _showBottomSheet

  fun showSheet() {
    _showBottomSheet.value = true
  }

  fun hideSheet() {
    _showBottomSheet.value = false
  }
}
