package com.example.expense_tracker_app.repository

import com.example.expense_tracker_app.data.Budget
import com.example.expense_tracker_app.data.BudgetCards
import com.example.expense_tracker_app.database.BudgetDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BudgetRepository @Inject constructor(private val budgetDao: BudgetDao) {

  suspend fun updateAvailableAmountAndAddBudget(id: Int?, newAmount: Double?, budget: Budget) {
    budgetDao.updateCardBalanceAndInsertBudget(id, newAmount, budget)
  }

  suspend fun updateBudgetAmountAndAddBudget(id: Int?, newAmount: Double?, availableAmount: Double, budget: Budget) {
    budgetDao.updateCardBudgetAndInsertBudget(id, newAmount, availableAmount, budget)
  }

  suspend fun getBudgetByType(type: String?): List<Budget> {
    return budgetDao.getBudgetByType(type)
  }

  suspend fun getBudgetCardById(id: Int): BudgetCards? {
    return budgetDao.getBudgetCardById(id)
  }

  fun getAllBudgets(): Flow<List<Budget>> {
    return budgetDao.getAllBudgets()
  }

  suspend fun getAllActivityCards(): List<BudgetCards> {
    return budgetDao.getAllCards()
  }

  suspend fun insertBudgetCards(budgets: List<BudgetCards>) {
    budgetDao.insertAllCards(budgets)
  }

}
