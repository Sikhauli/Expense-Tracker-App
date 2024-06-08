package com.example.expense_tracker_app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.expense_tracker_app.data.Spend

@Dao
interface SpendDao {
  @Query("SELECT * FROM spends WHERE id = :id")
  suspend fun getSpendById(id: Int): Spend

  @Query("SELECT * FROM spends")
  suspend fun getAllSpends(): List<Spend>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertSpend(spend: Spend)

  @Update
  suspend fun updateSpend(spend: Spend)
}