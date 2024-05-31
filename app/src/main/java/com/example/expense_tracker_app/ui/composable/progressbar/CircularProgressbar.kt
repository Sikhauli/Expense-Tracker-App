package com.example.expense_tracker_app.ui.composable.progressbar

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CircularProgressBarSample() {
  val progress by remember { mutableFloatStateOf(65f) }
  val startAngle by remember { mutableFloatStateOf(0f) }
  val progressBarWidth by remember { mutableStateOf(20.dp) }
  val backgroundProgressBarWidth by remember { mutableStateOf(10.dp) }
  val roundBorder by remember { mutableStateOf(true) }

  Column(Modifier.padding(64.dp)) {
    val animProgress by animateFloatAsState(progress, label = "")

    CircularProgressBar(
      modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1.0f),
      progress = animProgress,
      progressMax = 100f,
      progressBarColor = Color.Blue,
      progressBarWidth = progressBarWidth,
      backgroundProgressBarColor = Color.Blue.copy(alpha = 0.15f),
      backgroundProgressBarWidth = backgroundProgressBarWidth,
      roundBorder = roundBorder,
      startAngle = startAngle
    )
  }
}

@Preview(showBackground = true)
@Composable
fun CircularProgressBarSamplePreview() {
  CircularProgressBarSample()
}
