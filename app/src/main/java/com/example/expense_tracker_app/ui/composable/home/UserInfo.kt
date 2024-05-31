package com.example.expense_tracker_app.ui.composable.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.expense_tracker_app.ui.theme.ExpensetrackerappTheme


@Composable
fun UserInfo(modifier: Modifier = Modifier) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Box(
      modifier = Modifier
        .size(35.dp)
        .background(Color.Transparent, shape = CircleShape),
      contentAlignment = Alignment.Center
    ){
      Image(
        painter = rememberImagePainter("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGxI3c4Cb1WKJeeOBfTI2FdvEDdMphqCv0cBl0vQ86TXejPyurjunggu7K9A&s"),
        contentDescription = "Example Image",
        modifier = Modifier
          .fillMaxSize()
      )
    }
    Box(
      modifier = Modifier
        .size(150.dp, 50.dp)
        .background(Color.Transparent, shape = RoundedCornerShape(4.dp)),
      contentAlignment = Alignment.Center
    ){
      Text(
        text = "Welcome",
        fontSize = 26.sp,
        fontWeight = FontWeight.ExtraBold,
        style = MaterialTheme.typography.labelMedium
      )
    }
    Box(
      modifier = Modifier
        .size(30.dp)
        .background(Color.Transparent, shape = RoundedCornerShape(10.dp))
        .border(2.dp, Color.Gray, RoundedCornerShape(4.dp)),
      contentAlignment = Alignment.Center
    ){
      Image(
        painter = rememberImagePainter("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGxI3c4Cb1WKJeeOBfTI2FdvEDdMphqCv0cBl0vQ86TXejPyurjunggu7K9A&s"),
        contentDescription = "Example Image",
        modifier = Modifier
          .fillMaxSize()
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun UserInfoPreview() {
  ExpensetrackerappTheme {
    UserInfo()
  }
}