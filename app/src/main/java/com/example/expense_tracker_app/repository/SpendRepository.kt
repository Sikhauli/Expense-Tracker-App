package com.example.expense_tracker_app.repository

import com.example.expense_tracker_app.data.Spend
import com.example.expense_tracker_app.database.BudgetDao
import com.example.expense_tracker_app.database.SpendDao
import javax.inject.Inject

  class SpendRepository @Inject constructor(private val spendDao: SpendDao) {

    suspend fun getSpendById(id: Int): Spend {
    return spendDao.getSpendById(id)
  }

  suspend fun getAllSpend(): List<Spend> {
    return spendDao.getAllSpends()
  }

  suspend fun insertSpend(spend: Spend) {
    spendDao.insertSpend(spend)
  }
}