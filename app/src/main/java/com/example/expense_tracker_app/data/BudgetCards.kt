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


val activityCardData = listOf(
  BudgetCards(1, "https://e7.pngegg.com/pngimages/204/398/png-clipart-volkswagen-beetle-vintage-car-automotive-design-sketch-car-compact-car-car-thumbnail.png", "Fuel", 0.0, 0.0),
  BudgetCards(2, "https://e7.pngegg.com/pngimages/138/773/png-clipart-vegetable-food-tomato-grocery-store-salad-fresh-fruits-and-vegetables-bunch-of-vegetables-natural-foods-leaf-vegetable-thumbnail.png", "Grocery", 0.0, 0.0),
  BudgetCards(3, "https://e7.pngegg.com/pngimages/424/569/png-clipart-party-carnival-crowd-silhouette-silhouette-of-party-holidays-public-relations-thumbnail.png", "Party", 0.0, 0.0),
  BudgetCards(4, "https://e7.pngegg.com/pngimages/269/964/png-clipart-pizza-delivery-restaurant-online-food-ordering-fast-delivery-food-logo-thumbnail.png", "Orders", 0.0, 0.0),
  BudgetCards(5, "https://e7.pngegg.com/pngimages/68/466/png-clipart-illustration-of-character-traveling-travel-tourism-euclidean-global-travel-backpack-computer-wallpaper-thumbnail.png", "Travel", 0.0, 0.0),
  BudgetCards(6, "https://e1.pngegg.com/pngimages/883/804/png-clipart-more-gudetama-thumbnail.png", "More", 0.0, 0.0)
)