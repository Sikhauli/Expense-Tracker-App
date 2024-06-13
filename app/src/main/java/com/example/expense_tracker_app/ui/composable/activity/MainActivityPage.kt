package com.example.expense_tracker_app.ui.composable.activity

import ScrollableRecentActivityList
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.expense_tracker_app.ui.composable.BottomSheetContent
import com.example.expense_tracker_app.viewModel.BottomSheetViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityPage(bottomSheetViewModel: BottomSheetViewModel, navController: NavController?, itemId: String) {
  val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

  LaunchedEffect(Unit) {
    bottomSheetViewModel.getBudgetCardById(itemId.toInt())
  }

  val activityCard by bottomSheetViewModel.budgetCard.observeAsState()

  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text(text = "${activityCard?.activityName} Wallet") },
        navigationIcon = {
          IconButton(onClick = { navController?.navigateUp() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
          }
        },
        modifier = Modifier.background(MaterialTheme.colorScheme.primary),
        scrollBehavior = scrollBehavior
      )
    },
    content = { paddingValues ->
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(paddingValues)
          .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            text = "R${activityCard?.availableAmount}",
            fontSize = 70.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Serif,
            style = MaterialTheme.typography.titleLarge
          )
          Text(
            text = "Budget in one month is R${activityCard?.budget}",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.W300,
          )
        }

        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(top = 26.dp, bottom = 10.dp),
          verticalArrangement = Arrangement.Center,
        ) {
          Text(
            text = "Spending Activity",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.W800,
          )
        }

        Column(
          modifier = Modifier.fillMaxWidth(),
          verticalArrangement = Arrangement.Center,
        ) {
          Text(
            text = "Wallet Details",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.W800,
            modifier = Modifier.padding(vertical = 6.dp)
          )
          Text(
            text = "A wallet to manage expenses for ${activityCard?.activityName} in one month",
            fontFamily = FontFamily.Serif,
            fontSize = 12.sp,
            style = MaterialTheme.typography.displaySmall.copy(
              lineHeight = 14.sp
            ),
          )
        }
        Spacer(modifier = Modifier.height(10.dp))
        ScrollableRecentActivityList()
      }
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(bottom = 0.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
          horizontalArrangement = Arrangement.SpaceEvenly
        ) {
          Button(
            onClick = {
              bottomSheetViewModel.showSheet(isForEditBudget = true, isForSpend = false)
            },
            modifier = Modifier
              .size(160.dp, 60.dp)
              .border(1.dp, Color.Gray, shape = RoundedCornerShape(4.dp))
              .background(Color.LightGray, shape = RoundedCornerShape(4.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
          ) {
            Text(
              text = "Edit Budget",
              fontSize = 20.sp,
              fontFamily = FontFamily.Serif,
              color = MaterialTheme.colorScheme.onPrimary
            )
          }
          Spacer(modifier = Modifier.width(5.dp))
          Button(
            onClick = {
              bottomSheetViewModel.showSheet(isForEditBudget = false, isForSpend = true)
            },
            modifier = Modifier
              .size(190.dp, 60.dp)
              .border(2.dp, Color.Gray, shape = RoundedCornerShape(4.dp))
              .background(Color.Black, shape = RoundedCornerShape(4.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
          ) {
            Text(
              text = "Spend",
              fontSize = 20.sp,
              fontFamily = FontFamily.Serif,
              color = MaterialTheme.colorScheme.onPrimary
            )
          }
        }
        BottomSheetContent(bottomSheetViewModel, activityCard)
      }
    }
  )
}



