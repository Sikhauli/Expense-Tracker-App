package com.example.expense_tracker_app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.expense_tracker_app.data.Budget
import com.example.expense_tracker_app.data.BudgetCards
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertAllCards(budgets: List<BudgetCards>)

  @Query("SELECT * FROM budgets_cards")
  suspend fun getAllCards(): List<BudgetCards>

  @Query("SELECT * FROM budgets")
  fun getAllBudgets(): Flow<List<Budget>>

  @Query("SELECT * FROM budgets WHERE type = :type")
  suspend fun getBudgetByType( type: String?): List<Budget>

  @Query("SELECT * FROM budgets_cards WHERE id = :id")
  suspend fun getBudgetCardById(id: Int): BudgetCards?

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertBudget(budget: Budget)

  @Query("UPDATE budgets_cards SET availableAmount = :newAmount WHERE id = :id")
  suspend fun updateAvailableAmount(id: Int?, newAmount: Double?)

  @Query("UPDATE budgets_cards SET budget = :newAmount, availableAmount = :newAvailableAmount WHERE id = :id")
  suspend fun updateBudgetAmount(id: Int?, newAmount: Double?, newAvailableAmount: Double)

  @Transaction
  suspend fun updateCardBudgetAndInsertBudget(id: Int?, newAmount: Double?, availableAmount: Double, budget: Budget) {
    updateBudgetAmount(id, newAmount, availableAmount)
    insertBudget(budget)
  }

  @Transaction
  suspend fun updateCardBalanceAndInsertBudget(id: Int?, newAmount: Double?, budget: Budget) {
    updateAvailableAmount(id, newAmount)
    insertBudget(budget)
  }



}
