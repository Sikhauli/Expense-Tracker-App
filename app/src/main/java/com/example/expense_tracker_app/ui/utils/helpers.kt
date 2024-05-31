package com.example.expense_tracker_app.ui.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun LimitedText(text: String, maxCharacters: Int = 10) {
  val displayedText = if (text.length > maxCharacters) {
    text.take(maxCharacters) + "..."
  } else {
    text
  }
  Text(
    text = displayedText,
    textAlign = TextAlign.Center,
    style = MaterialTheme.typography.bodyMedium
  )
}

@Composable
fun myText(number: Int, fontSize: Int){
  Text(
    text = number.toString(),
    style = TextStyle(
      color = Color.Black,
      fontSize = fontSize.sp,
      fontWeight = FontWeight.Thin
    )
  )
}