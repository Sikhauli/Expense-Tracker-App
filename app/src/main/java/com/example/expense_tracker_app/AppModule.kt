package com.example.expense_tracker_app

import android.content.Context
import androidx.room.Room
import com.example.expense_tracker_app.database.BudgetDao
import com.example.expense_tracker_app.repository.BudgetRepository
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
      "expenses_tracker_database"
    ).build()
  }

  @Provides
  fun provideBudgetDao(database: AppDatabase): BudgetDao {
    return database.budgetDao()
  }

  @Provides
  @Singleton
  fun provideBudgetRepository(budgetDao: BudgetDao): BudgetRepository {
    return BudgetRepository(budgetDao)
  }
}
