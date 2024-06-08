package com.example.expense_tracker_app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.expense_tracker_app.data.Budget

@Dao
interface BudgetDao {
  @Query("SELECT * FROM budgets WHERE id = :id")
  suspend fun getBudgetById(id: Int): Budget?

  @Query("SELECT * FROM budgets")
  suspend fun getAllBudgets(): List<Budget>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertBudget(budget: Budget)

  @Update
  suspend fun updateBudget(budget: Budget)
}
