package com.example.expense_tracker_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expense_tracker_app.data.Budget
import com.example.expense_tracker_app.data.BudgetCards
import com.example.expense_tracker_app.data.activityCardData
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

  private val _activityCards = MutableLiveData<List<BudgetCards>>()
  val activityCards: LiveData<List<BudgetCards>> get() = _activityCards

  private val _allBudgets = MutableStateFlow<List<Budget>>(emptyList())
  val allBudgets: StateFlow<List<Budget>> get() = _allBudgets

  init {
    loadAllBudgets()
  }

  private fun loadAllBudgets() {
    viewModelScope.launch {
      repository.getAllBudgets().collect { budgets ->
        _allBudgets.value = budgets
      }
    }
  }

  fun populateDatabase() {
    viewModelScope.launch {
      repository.insertBudgetCards(activityCardData)
    }
  }

  fun getAllActivityCards() {
    viewModelScope.launch {
      val cards = repository.getAllActivityCards()
      _activityCards.value = cards
    }
  }

}
