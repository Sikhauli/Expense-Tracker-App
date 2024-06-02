package com.example.expense_tracker_app.data

data class ActivityCard(
  val id: Number,
  val img: String,
  val activityName: String,
  val availableAmount: Number,
  val budget: Number
)

val ActivityCardData = listOf(
  ActivityCard(1, "https://e-cdn-images.dzcdn.net/images/artist/5d9f16fae9f8cd9f2bfd9103f08079a3/500x500-000000-80-0-0.jpg", "Fuel", 1500, 5000  ),
  ActivityCard(2, "https://e-cdn-images.dzcdn.net/images/artist/cf9f43ee1f0d8d3b498a155f4988087f/500x500-000000-80-0-0.jpg", "Grocery", 2500, 5500),
  ActivityCard(3, "https://lastfm.freetls.fastly.net/i/u/770x0/434a922ecca5474f1f9d6bbcc3a1050c.jpg#434a922ecca5474f1f9d6bbcc3a1050c","Party",6300, 10000),
  ActivityCard(4, "https://t2.genius.com/unsafe/300x300/https%3A%2F%2Fimages.genius.com%2F58f44c045af8c84db70abf4f2d2c6e1f.1000x1000x1.jpg","Orders",1700, 2500),
  ActivityCard(5, "https://t2.genius.com/unsafe/252x252/https%3A%2F%2Fimages.genius.com%2F130420153ed8ff63bab74dd483030456.1000x1000x1.png","Travel",17734, 25000),
  ActivityCard(6, "https://t2.genius.com/unsafe/252x252/https%3A%2F%2Fimages.genius.com%2Fd97224e10b88dcd05ed18b87366461c8.600x600x1.jpg","More", 10000, 8890),
)
