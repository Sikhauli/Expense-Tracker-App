package com.example.expense_tracker_app.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expense_tracker_app.ui.theme.ExpensetrackerappTheme
import com.example.expense_tracker_app.viewModel.BottomSheetViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun BottomSheetContent(bottomSheetViewModel: BottomSheetViewModel = viewModel()) {
  val showBottomSheet by bottomSheetViewModel.showBottomSheet.collectAsState()
  val sheetState = rememberModalBottomSheetState()
  val scope = rememberCoroutineScope()
  var name by remember { mutableStateOf("") }
  var amount by remember { mutableStateOf("") }

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
        Text("Add New Entry", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(
          value = name,
          onValueChange = { name = it },
          label = { Text("Name") },
          modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
          value = amount,
          onValueChange = { amount = it },
          label = { Text("Amount") },
          modifier = Modifier.fillMaxWidth()
        )
        Row(
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          modifier = Modifier.align(Alignment.End)
        ) {
          Button(
            onClick = {
              // Handle the save action
              // For now, just print the values to the console
              println("Name: $name, Amount: $amount")

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


@Preview(showBackground = true)
@Composable
fun BottomSheetContentPreview() {
  ExpensetrackerappTheme {
    BottomSheetContent()
  }
}











