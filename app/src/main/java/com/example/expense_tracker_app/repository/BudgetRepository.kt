package com.example.expense_tracker_app.repository

import com.example.expense_tracker_app.data.Budget
import com.example.expense_tracker_app.database.BudgetDao
import javax.inject.Inject

class BudgetRepository @Inject constructor(private val budgetDao: BudgetDao) {
  suspend fun getBudgetById(id: Int): Budget? {
    return budgetDao.getBudgetById(id)
  }

  suspend fun getAllBudgets(): List<Budget> {
    return budgetDao.getAllBudgets()
  }

  suspend fun insertBudget(budget: Budget) {
    budgetDao.insertBudget(budget)
  }

  suspend fun updateBudget(budget: Budget) {
    budgetDao.updateBudget(budget)
  }
}
