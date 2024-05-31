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
fun Wallet() {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Column(
      modifier = Modifier
        .size(250.dp, 60.dp)
        .background(Color.Transparent, shape = RoundedCornerShape(4.dp)),
      verticalArrangement = Arrangement.Center,
    ){
      Text(
        text = "My Wallet",
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold,
        style = MaterialTheme.typography.labelLarge
      )
      Spacer(modifier = Modifier.padding(2.dp) )
      Text(
        text = "R50,000 (Total in 6 wallets)",
        fontSize = 14.sp,
        fontWeight = FontWeight.ExtraBold,
        style = MaterialTheme.typography.titleSmall
      )
    }
    Box(
      modifier = Modifier
        .size(30.dp)
        .background(Color.Transparent, shape = RoundedCornerShape(30.dp))
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
fun WalletPreview() {
  ExpensetrackerappTheme {
    Wallet()
  }
}