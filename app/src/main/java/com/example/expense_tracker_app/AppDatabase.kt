package com.example.expense_tracker_app

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.expense_tracker_app.data.Budget
import com.example.expense_tracker_app.data.BudgetCards
import com.example.expense_tracker_app.database.BudgetDao

@Database(entities = [BudgetCards::class, Budget::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
  abstract fun budgetDao(): BudgetDao
}