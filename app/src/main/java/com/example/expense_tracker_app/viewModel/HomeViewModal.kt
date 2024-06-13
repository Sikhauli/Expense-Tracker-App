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

@HiltViewModel
class HomeViewModal @Inject constructor(
  private val repository: BudgetRepository
) : ViewModel() {

  private val _allBudgets = MutableStateFlow<List<Budget>>(emptyList())
  val allBudgets: StateFlow<List<Budget>> = _allBudgets

  private val _activityCards = MutableLiveData<List<BudgetCards>>()
  val activityCards: LiveData<List<BudgetCards>> get() = _activityCards


  fun loadAllBudgets() {
    viewModelScope.launch {
      _allBudgets.value = repository.getAllBudgets()
    }
  }

  fun updateAvailableAmountAndAddBudget(id: Int, newAmount: Double, budget: Budget) {
    viewModelScope.launch {
      repository.updateAvailableAmountAndAddBudget(id, newAmount, budget)
    }
  }

  fun updateBudgetAmountAndAddBudget(id: Int, newAmount: Double, budget: Budget) {
    viewModelScope.launch {
      repository.updateBudgetAmountAndAddBudget(id, newAmount, budget)
    }
  }

  fun getAllActivityCards() {
    viewModelScope.launch {
      val cards = repository.getAllActivityCards()
      _activityCards.value = cards
    }
  }

}
