package com.example.expense_tracker_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budgets")
data class Budget(
  @PrimaryKey(autoGenerate = true) val id: Int = 0,
  val idd: Int? = 0,
  val amount: Double?,
  val availableAmount: Double?,
  val date: String,
  val name: String,
  val type: String?,
)


