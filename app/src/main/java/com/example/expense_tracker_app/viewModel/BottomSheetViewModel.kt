package com.example.expense_tracker_app.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expense_tracker_app.data.Budget
import com.example.expense_tracker_app.repository.BudgetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class SaveResult {
  SUCCESS,
  FAILURE
}
@HiltViewModel
class BottomSheetViewModel @Inject constructor(
  private val repository: BudgetRepository
) : ViewModel() {

  private val _saveResult = MutableStateFlow<SaveResult?>(null)
  val saveResult: StateFlow<SaveResult?> = _saveResult

  private val _showBottomSheet = MutableStateFlow(false)
  val showBottomSheet: StateFlow<Boolean> = _showBottomSheet

  private val _isForSpend = MutableStateFlow(false)
  val isForSpend: StateFlow<Boolean> = _isForSpend

  private val _isForEditBudget = MutableStateFlow(false)
  val isForEditBudget: StateFlow<Boolean> = _isForEditBudget

  private val _budget = MutableStateFlow<Budget?>(null)
  val budget: StateFlow<Budget?> = _budget

  private val _allBudgets = MutableStateFlow<List<Budget>>(emptyList())
  val allBudgets: StateFlow<List<Budget>> = _allBudgets

  fun showSheet(isForSpend: Boolean, isForEditBudget: Boolean) {
    _isForSpend.value = isForSpend
    _isForEditBudget.value = isForEditBudget
    _showBottomSheet.value = true
  }

  fun hideSheet() {
    _showBottomSheet.value = false
  }

  fun loadAllBudgets() {
    viewModelScope.launch {
      _allBudgets.value = repository.getAllBudgets()
    }
  }

  fun loadBudget(id: Int) {
    viewModelScope.launch {
      _budget.value = repository.getBudgetById(id)
    }
  }

  fun saveBudget(budget: Budget) {
    viewModelScope.launch {
      try {
        if (budget.id == 0) {
          repository.insertBudget(budget)
        } else {
          repository.updateBudget(budget)
        }
        _saveResult.value = SaveResult.SUCCESS
      } catch (e: Exception) {
        _saveResult.value = SaveResult.FAILURE
      }
    }
  }

  fun clearSaveResult() {
    _saveResult.value = null
  }

}
