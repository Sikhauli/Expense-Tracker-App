package com.example.expense_tracker_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expense_tracker_app.data.Budget
import com.example.expense_tracker_app.data.BudgetCards
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

//  private val _budgetCard = MutableStateFlow<BudgetCards?>(null)
//  val budgetCard: MutableStateFlow<BudgetCards?> = _budgetCard

  private val _budgetCard = MutableLiveData<BudgetCards>()
  val budgetCard: LiveData<BudgetCards> get() = _budgetCard


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

  fun getBudgetCardById(id: Int) {
    viewModelScope.launch {
      _budgetCard.value = repository.getBudgetCardById(id)
    }
  }

  fun updateAvailableAmountAndAddBudget(id: Int?, newAmount: Double?, budget: Budget) {
    viewModelScope.launch {
      repository.updateAvailableAmountAndAddBudget(id, newAmount, budget)
    }
  }

  fun updateBudgetAmountAndAddBudget(id: Int?, newAmount: Double?, budget: Budget) {
    viewModelScope.launch {
      repository.updateBudgetAmountAndAddBudget(id, newAmount, budget)
    }
  }

  fun clearSaveResult() {
    _saveResult.value = null
  }

}
