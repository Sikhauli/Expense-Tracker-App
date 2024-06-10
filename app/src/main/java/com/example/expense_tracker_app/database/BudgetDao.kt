package com.example.expense_tracker_app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.expense_tracker_app.data.ActivityCard
import com.example.expense_tracker_app.data.Budget

@Dao
interface BudgetDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertAllCards(activityCards: List<ActivityCard>)

  @Query("SELECT * FROM budgets_cards")
  suspend fun getAllCards(): List<ActivityCard>


  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertBudget(budget: Budget)

  @Query("SELECT * FROM budgets WHERE id = :id")
  suspend fun getBudgetById(id: Int): Budget?

  @Query("UPDATE budgets_cards SET availableAmount = :newAmount WHERE id = :id")
  suspend fun updateAvailableAmount(id: Int, newAmount: Double)

  @Query("UPDATE budgets_cards SET budget = :newAmount WHERE id = :id")
  suspend fun updateBudgetAmount(id: Int, newAmount: Double)

  @Transaction
  suspend fun updateCardBudgetAndInsertBudget(id: Int, newAmount: Double, budget: Budget) {
    updateAvailableAmount(id, newAmount)
    insertBudget(budget)
  }

  @Transaction
  suspend fun updateCardBalanceAndInsertBudget(id: Int, newAmount: Double, budget: Budget) {
    updateBudgetAmount(id, newAmount)
    insertBudget(budget)
  }

  @Query("SELECT * FROM budgets")
  suspend fun getAllBudgets(): List<Budget>

}
