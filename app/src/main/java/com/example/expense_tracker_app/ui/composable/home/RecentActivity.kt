import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expense_tracker_app.data.Budget

@Composable
fun RecentActivityItem(
  icon: ImageVector,
  title: String,
  date: String,
  description: String
) {
  Surface(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp)
      .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(10.dp)),
    shadowElevation = 8.dp,
    shape = MaterialTheme.shapes.medium,
    color = MaterialTheme.colorScheme.surface
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .background(Color.Transparent, shape = RoundedCornerShape(10.dp))
        .padding(16.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Icon(
        imageVector = icon,
        contentDescription = null,
        tint = Color.Gray,
        modifier = Modifier
          .size(40.dp)
          .background(Color.Gray, shape = RoundedCornerShape(50))
          .padding(8.dp)
      )

      Spacer(modifier = Modifier.width(16.dp))

      Column(
        verticalArrangement = Arrangement.Center
      ) {
        Text(
          text = title,
          style = MaterialTheme.typography.bodyLarge,
          fontFamily = FontFamily.Serif,
          fontSize = 16.sp
        )
        Text(
          text = date,
          fontFamily = FontFamily.Serif,
          style = MaterialTheme.typography.bodyMedium,
          color = Color.Gray,
          fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = description,
          fontFamily = FontFamily.Serif,
          style = MaterialTheme.typography.bodySmall,
          fontSize = 14.sp
        )
      }
    }
  }
}

@Composable
fun ScrollableRecentActivityList(budgets: List<Budget>) {
  Column {
    val scrollState = rememberScrollState()
    Row(
      modifier = Modifier
        .fillMaxWidth()
    ) {
      Text(
        text = "Recent Activities",
        fontSize = 16.sp,
        fontFamily = FontFamily.Serif,
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.padding(vertical = 8.dp)
      )
    }
    Column(
      modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
    ) {
      if (budgets.isEmpty()) {
        Box(
          modifier = Modifier
            .fillMaxSize(),
          contentAlignment = Alignment.Center
        ) {
          Text("No budgets available")
        }
      } else {
        budgets.forEach { budget ->
          budget.type?.let {
            RecentActivityItem(
              icon = Icons.Default.AttachMoney,
              title = budget.name,
              date = budget.date,
              description = it
            )
          }
        }
      }
    }
  }
}