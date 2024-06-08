package com.example.expense_tracker_app

import android.content.Context
import androidx.room.Room
import com.example.expense_tracker_app.database.BudgetDao
import com.example.expense_tracker_app.database.SpendDao
import com.example.expense_tracker_app.repository.BudgetRepository
import com.example.expense_tracker_app.repository.SpendRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  @Provides
  @Singleton
  fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
    return Room.databaseBuilder(
      context.applicationContext,
      AppDatabase::class.java,
      "budget_database"
    ).build()
  }

  @Provides
  fun provideBudgetDao(database: AppDatabase): BudgetDao {
    return database.budgetDao()
  }

  @Provides
  fun provideSpendDao(database: AppDatabase): SpendDao {
    return database.spendDao()
  }

  @Provides
  @Singleton
  fun provideSpendRepository(spendDao: SpendDao): SpendRepository {
    return SpendRepository(spendDao)
  }

  @Provides
  @Singleton
  fun provideBudgetRepository(budgetDao: BudgetDao): BudgetRepository {
    return BudgetRepository(budgetDao)
  }
}
