package com.example.expense_tracker_app.ui.composable.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.expense_tracker_app.ui.theme.ExpensetrackerappTheme


@Composable
fun UserInfo() {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(bottom = 16.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Box(
      modifier = Modifier
        .size(35.dp)
        .background(Color.Transparent, shape = RoundedCornerShape(5.dp))
        .border(0.dp, Color.Gray, RoundedCornerShape(5.dp)),
      contentAlignment = Alignment.Center
    ){
      Image(
        painter = rememberImagePainter("https://p7.hiclipart.com/preview/980/304/8/computer-icons-user-profile-avatar-thumbnail.jpg"),
        contentDescription = "User Image",
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
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.ExtraBold,
        style = MaterialTheme.typography.labelMedium
      )
    }
    Box(
      modifier = Modifier
        .size(30.dp)
        .background(Color.Transparent, shape = RoundedCornerShape(4.dp))
        .border(0.dp, Color.Gray, RoundedCornerShape(4.dp)),
      contentAlignment = Alignment.Center
    ){
      Image(
        painter = rememberImagePainter("https://p7.hiclipart.com/preview/798/442/417/computer-icons-bell-clip-art-bell-thumbnail.jpg"),
        contentDescription = "Notification Image",
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