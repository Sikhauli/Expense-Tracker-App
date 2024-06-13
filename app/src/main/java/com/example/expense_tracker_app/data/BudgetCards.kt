package com.example.expense_tracker_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budgets_cards")
data class BudgetCards(
  @PrimaryKey(autoGenerate = true) val id: Int = 0,
  val img: String,
  val activityName: String,
  val availableAmount: Double,
  val budget: Double
)
