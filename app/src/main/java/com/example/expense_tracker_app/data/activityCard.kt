package com.example.expense_tracker_app.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ActivityCard(
  val id: Int,
  val img: String,
  val activityName: String,
  val availableAmount: Number,
  val budget: Number
) : Parcelable

val ActivityCardData = listOf(
  ActivityCard(1, "https://e7.pngegg.com/pngimages/204/398/png-clipart-volkswagen-beetle-vintage-car-automotive-design-sketch-car-compact-car-car-thumbnail.png", "Fuel", 1500, 5000  ),
  ActivityCard(2, "https://e7.pngegg.com/pngimages/138/773/png-clipart-vegetable-food-tomato-grocery-store-salad-fresh-fruits-and-vegetables-bunch-of-vegetables-natural-foods-leaf-vegetable-thumbnail.png", "Grocery", 2500, 5500),
  ActivityCard(3, "https://e7.pngegg.com/pngimages/424/569/png-clipart-party-carnival-crowd-silhouette-silhouette-of-party-holidays-public-relations-thumbnail.png","Party",6300, 10000),
  ActivityCard(4, "https://e7.pngegg.com/pngimages/269/964/png-clipart-pizza-delivery-restaurant-online-food-ordering-fast-delivery-food-logo-thumbnail.png","Orders",1700, 2500),
  ActivityCard(5, "https://e7.pngegg.com/pngimages/68/466/png-clipart-illustration-of-character-traveling-travel-tourism-euclidean-global-travel-backpack-computer-wallpaper-thumbnail.png","Travel",17734, 25000),
  ActivityCard(6, "https://e1.pngegg.com/pngimages/883/804/png-clipart-more-gudetama-thumbnail.png","More", 10000, 8890),
)
