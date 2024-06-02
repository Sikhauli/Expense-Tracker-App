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
import androidx.compose.ui.text.font.FontFamily
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
      .fillMaxWidth(),
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
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.SemiBold,
        style = MaterialTheme.typography.labelLarge
      )
      Spacer(modifier = Modifier.padding(2.dp) )
      Text(
        text = "R50,000 (Total in 6 wallets)",
        fontSize = 14.sp,
        fontFamily = FontFamily.Serif,
        style = MaterialTheme.typography.titleSmall
      )
    }
    Box(
      modifier = Modifier
        .size(30.dp)
        .background(Color.Transparent, shape = RoundedCornerShape(4.dp))
        .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp)),
      contentAlignment = Alignment.Center
    ){
      Image(
        painter = rememberImagePainter("https://static.vecteezy.com/system/resources/previews/010/160/090/non_2x/add-icon-sign-symbol-design-free-png.png"),
        contentDescription = "Add Image",
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