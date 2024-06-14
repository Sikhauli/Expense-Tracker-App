package com.example.expense_tracker_app.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expense_tracker_app.data.Budget
import com.example.expense_tracker_app.data.BudgetCards
import com.example.expense_tracker_app.viewModel.BottomSheetViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun BottomSheetContent(
  bottomSheetViewModel: BottomSheetViewModel = viewModel(),
  activityCard: BudgetCards?,
) {
  val showBottomSheet by bottomSheetViewModel.showBottomSheet.collectAsState()
  val isForSpend by bottomSheetViewModel.isForSpend.collectAsState()
  val sheetState = rememberModalBottomSheetState()
  val scope = rememberCoroutineScope()
  var spendAmount by remember { mutableStateOf("") }
  var budget by remember { mutableStateOf("") }
  val saveResult by bottomSheetViewModel.saveResult.collectAsState()
  val currentDate = LocalDate.now()
  val formatter = SimpleDateFormat("EEE MMM dd", Locale.getDefault())
  val date = formatter.format(Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()))

  if (saveResult != null) {
    LaunchedEffect(Unit) {
      delay(3000)
      bottomSheetViewModel.clearSaveResult()
    }
  }

  LaunchedEffect(showBottomSheet) {
    if (showBottomSheet) {
      sheetState.show()
    } else {
      sheetState.hide()
    }
  }

  val isImeVisible = WindowInsets.isImeVisible
  val navigationBottomHeight = WindowInsets.systemBars.asPaddingValues().calculateBottomPadding()

  if (showBottomSheet) {
    ModalBottomSheet(
      onDismissRequest = {
        bottomSheetViewModel.hideSheet()
      },
      sheetState = sheetState
    ) {
      Column(
        modifier = Modifier
          .padding(
            start = 16.dp,
            end = 16.dp,
            bottom = if (isImeVisible) navigationBottomHeight else 16.dp
          )
          .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        Text(
          text = if (isForSpend) "Spend Money" else "Edit Budget",
          style = MaterialTheme.typography.headlineMedium
        )
        if (isForSpend) {
          OutlinedTextField(
            value = spendAmount,
            onValueChange = { spendAmount = it },
            label = { Text("Spending Amount") },
            modifier = Modifier.fillMaxWidth()
          )
        } else {
          OutlinedTextField(
            value = budget,
            onValueChange = { budget = it },
            label = { Text("Budget Deposit") },
            modifier = Modifier.fillMaxWidth()
          )
        }

        Row(
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          modifier = Modifier.align(Alignment.End)
        ) {
          Button(
            onClick = {
              if (isForSpend) {
                //For Spend
                val updatedAvailableAmount = activityCard?.availableAmount?.minus(spendAmount.toDouble())
                val newSpend = Budget(
                  idd = activityCard?.id,
                  amount = activityCard?.budget,
                  availableAmount = updatedAvailableAmount,
                  date = date,
                  name = "Spend Money",
                  type = activityCard?.activityName,
                )
                println("newSpend:  $newSpend")
                bottomSheetViewModel.updateAvailableAmountAndAddBudget(
                  activityCard?.id,
                  updatedAvailableAmount,
                  newSpend
                )
              } else {
                //For Budget
                val updatedNewBudget = activityCard?.budget?.plus(budget.toDouble())
                val availableAmount = activityCard?.availableAmount?.plus(budget.toDouble())
                val newBudget = Budget(
                  idd = activityCard?.id,
                  amount = updatedNewBudget,
                  availableAmount = availableAmount,
                  date = date,
                  name = "New Deposit",
                  type = activityCard?.activityName,
                )
                println("newBudget:  $newBudget")
                if (availableAmount != null) {
                  bottomSheetViewModel.updateBudgetAmountAndAddBudget(activityCard.id, updatedNewBudget, availableAmount, newBudget)
                }
              }
              scope.launch {
                sheetState.hide()
                bottomSheetViewModel.hideSheet()
              }
            }
          ) {
            Text("Save")
          }
          Button(
            onClick = {
              scope.launch {
                sheetState.hide()
                bottomSheetViewModel.hideSheet()
              }
            }
          ) {
            Text("Cancel")
          }
        }
      }
    }
  }
}


