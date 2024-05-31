import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expense_tracker_app.ui.screens.home.Home
import com.example.expense_tracker_app.ui.theme.ExpensetrackerappTheme

@Composable
fun RecentActivityItem(
  icon: ImageVector,
  title: String,
  date: String,
  description: String
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp)
      .background(Color.White, shape = RoundedCornerShape(10.dp))
      .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(10.dp))
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
        fontFamily = FontFamily.SansSerif,
        fontSize = 16.sp
      )
      Text(
        text = date,
        style = MaterialTheme.typography.bodyMedium,
        color = Color.Gray,
        fontSize = 14.sp
      )
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = description,
        style = MaterialTheme.typography.bodySmall,
        fontSize = 14.sp
      )
    }
  }
}

@Composable
fun ScrollableRecentActivityList() {
  val scrollState = rememberScrollState()

  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(scrollState)
      .padding(8.dp)
  ) {

    Row(

    ){

    }

    val recentActivities = listOf(
      Triple("Deposit", "2024-05-31", "You have deposited $500"),
      Triple("Withdrawal", "2024-05-30", "You have withdrawn $200"),
      Triple("Transfer", "2024-05-29", "You have transferred $300 to Alice"),
      Triple("Deposit", "2024-05-28", "You have deposited $150")
    )

    recentActivities.forEach { (title, date, description) ->
      RecentActivityItem(
        icon = Icons.Default.Home,
        title = title,
        date = date,
        description = description
      )
      Spacer(modifier = Modifier.height(8.dp))
    }
  }
}



@Preview(showBackground = true)
@Composable
fun ScrollableRecentActivityListPreview() {
  ExpensetrackerappTheme {
    ScrollableRecentActivityList()
  }
}