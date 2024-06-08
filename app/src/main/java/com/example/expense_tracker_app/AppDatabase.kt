package com.example.expense_tracker_app

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.expense_tracker_app.data.Budget
import com.example.expense_tracker_app.data.Spend
import com.example.expense_tracker_app.database.BudgetDao
import com.example.expense_tracker_app.database.SpendDao

@Database(entities = [Budget::class, Spend::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
  abstract fun budgetDao(): BudgetDao
  abstract fun spendDao(): SpendDao
}