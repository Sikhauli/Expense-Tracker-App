package com.example.expense_tracker_app.repository

import androidx.room.Query
import com.example.expense_tracker_app.data.Budget
import com.example.expense_tracker_app.data.BudgetCards
import com.example.expense_tracker_app.database.BudgetDao
import javax.inject.Inject

class BudgetRepository @Inject constructor(private val budgetDao: BudgetDao) {

  suspend fun updateAvailableAmountAndAddBudget(id: Int?, newAmount: Double?, budget: Budget) {
    budgetDao.updateCardBalanceAndInsertBudget(id, newAmount, budget)
  }

  suspend fun updateBudgetAmountAndAddBudget(id: Int?, newAmount: Double?, budget: Budget) {
    budgetDao.updateCardBudgetAndInsertBudget(id, newAmount, budget)
  }

  suspend fun getBudgetCardById(id: Int): BudgetCards? {
    return budgetDao.getBudgetCardById(id)
  }

  suspend fun getAllBudgets(): List<Budget> {
    return budgetDao.getAllBudgets()
  }

  suspend fun getAllActivityCards(): List<BudgetCards> {
    return budgetDao.getAllCards()
  }

  suspend fun insertBudget(budget: Budget) {
    budgetDao.insertBudget(budget)
  }
}
