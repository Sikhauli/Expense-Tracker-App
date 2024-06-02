package com.example.expense_tracker_app.ui.composable.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expense_tracker_app.ui.theme.ExpensetrackerappTheme

@Composable
fun ProfileCompletion(){
   Row(
     modifier = Modifier
       .fillMaxWidth()
       .border(1.dp,  Color.LightGray, shape = MaterialTheme.shapes.medium)
       .background(Color.Transparent, shape = MaterialTheme.shapes.medium),
     horizontalArrangement = Arrangement.SpaceBetween,
     ){
    Box(
      modifier = Modifier
        .size(220.dp, 100.dp)
        .padding(8.dp),
      ){
      
      Text(
        text = "Complete your data for account verification",
        fontSize = 26.sp,
        fontFamily = FontFamily.Serif,
        style = MaterialTheme.typography.displaySmall.copy(
          lineHeight = 26.sp
        ),
      )
    }
     Box(
       modifier = Modifier
         .size(100.dp, 100.dp)
         .padding(8.dp)
     ){
        Text("Hello")
     }
   }
}

@Preview(showBackground = true)
@Composable
fun ProfileCompletionPreview() {
  ExpensetrackerappTheme {
    ProfileCompletion()
  }
}