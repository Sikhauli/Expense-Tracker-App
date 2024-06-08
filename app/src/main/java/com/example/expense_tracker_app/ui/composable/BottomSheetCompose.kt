package com.example.expense_tracker_app.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expense_tracker_app.R
import com.example.expense_tracker_app.data.ActivityCard
import com.example.expense_tracker_app.data.Budget
import com.example.expense_tracker_app.viewModel.BottomSheetViewModel
import com.example.expense_tracker_app.viewModel.SaveResult.FAILURE
import com.example.expense_tracker_app.viewModel.SaveResult.SUCCESS
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
  activityCard: ActivityCard
) {
  val showBottomSheet by bottomSheetViewModel.showBottomSheet.collectAsState()
  val isForSpend by bottomSheetViewModel.isForSpend.collectAsState()
  val sheetState = rememberModalBottomSheetState()
  val scope = rememberCoroutineScope()
  var amount by remember { mutableStateOf("") }
  var availableAmount by remember { mutableStateOf("") }
  var budget by remember { mutableStateOf("") }
  val saveResult by bottomSheetViewModel.saveResult.collectAsState()
  val currentDate = LocalDate.now()
  val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
  val formattedDate = formatter.format(Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()))
  val date = formatter.parse(formattedDate)

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

  println("activityCard: $activityCard")
  println("date: $date")

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
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") },
            modifier = Modifier.fillMaxWidth()
          )
        } else {
          OutlinedTextField(
            value = budget,
            onValueChange = { budget = it },
            label = { Text("Budget") },
            modifier = Modifier.fillMaxWidth()
          )
          OutlinedTextField(
            value = availableAmount,
            onValueChange = { availableAmount = it },
            label = { Text("Available Amount") },
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
                val newSpend = date?.let {
                  Budget(
                    idd = activityCard.id,
                    amount = budget.toDouble(),
                    availableAmount = availableAmount.toDouble(),
                    date = it.toString(),
                    name = "Spend",
                    type = activityCard.activityName
                  )
                }
                if (newSpend != null) {
                  bottomSheetViewModel.saveBudget(newSpend)
                }
              } else {
                val newBudget = date?.let {
                  Budget(
                    idd = activityCard.id,
                    amount = budget.toDouble(),
                    availableAmount = availableAmount.toDouble(),
                    date = it.toString(),
                    name = "Deposit",
                    type = activityCard.activityName
                  )
                }
                if (newBudget != null) {
                  bottomSheetViewModel.saveBudget(newBudget)
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
  if (saveResult != null) {
    val message = when (saveResult) {
      SUCCESS -> stringResource(id = R.string.success_message)
      FAILURE -> stringResource(id = R.string.failure_message)
      null -> TODO()
    }
    Snackbar(
      modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 10.dp)
    ) {
      Text(
        text = message,
        modifier = Modifier.padding(8.dp)
      )
    }
  }
}


