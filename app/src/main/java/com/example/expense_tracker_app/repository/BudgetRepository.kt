package com.example.expense_tracker_app.repository

import com.example.expense_tracker_app.data.Budget
import com.example.expense_tracker_app.database.BudgetDao
import javax.inject.Inject

class BudgetRepository @Inject constructor(private val budgetDao: BudgetDao) {

  suspend fun updateAvailableAmountAndAddBudget(id: Int, newAmount: Double, budget: Budget) {
    budgetDao.updateCardBalanceAndInsertBudget(id, newAmount, budget)
  }

  suspend fun updateBudgetAmountAndAddBudget(id: Int, newAmount: Double, budget: Budget) {
    budgetDao.updateCardBudgetAndInsertBudget(id, newAmount, budget)
  }

  suspend fun getBudgetById(id: Int): Budget? {
    return budgetDao.getBudgetById(id)
  }

  suspend fun getAllBudgets(): List<Budget> {
    return budgetDao.getAllBudgets()
  }

  suspend fun insertBudget(budget: Budget) {
    budgetDao.insertBudget(budget)
  }
}
