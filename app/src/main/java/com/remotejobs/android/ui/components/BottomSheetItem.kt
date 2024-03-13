package com.remotejobs.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.AddTask
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.RemoveRedEye
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.TaskAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.remotejobs.android.ui.theme.BottomNavColor
import java.time.LocalDateTime

@Composable
fun BottomSheetItem(
    company: String,
    title: String,
    type: String,
    timePosted: LocalDateTime,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.clickable {
            onClick()
        }
    ) {

        Row(
        ) {
            Text(
                text = "SQL Developer", modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )

            Icon(Icons.Default.Share, contentDescription = null, tint = Color.Black)
        }

        Row {
            Text(
                text = "Ascendion",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
            Text(
                text = "United States",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
            Text(
                text = "1 week ago",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
            Text(
                text = "Over 100 applicants",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
        }

        Row {
            Icon(
                Icons.Rounded.AttachMoney, contentDescription = null, tint = Color.Black,
            )
            Text(
                text = "Pay: ",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
            Text(
                text = "100K - 180K",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
            Text(
                text = "Remote",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
            Text(
                text = "Full-time",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
            Text(
                text = "Mid-Senior level",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
        }

        Row {
            Icon(
                Icons.Rounded.ShoppingBag, contentDescription = null, tint = Color.Black,
            )
            Text(
                text = "Company Size: ",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
            Text(
                text = "10-20 employees",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
            Text(
                text = "Technology, Information and Internet",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
        }

        Row {
            Icon(
                Icons.Rounded.TaskAlt, contentDescription = null, tint = Color.Black,
            )
            Text(
                text = "Skills: ",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
            Text(
                text = "Oracle Database",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
            Text(
                text = "SQL",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
        }

        Row {
            Icon(
                Icons.Rounded.RemoveRedEye, contentDescription = null, tint = Color.Black,
            )
            Text(
                text = "Views: ",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
            Text(
                text = "87",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )

        }

        Row {
            Icon(
                Icons.Rounded.AddTask, contentDescription = null, tint = Color.Black,
            )
            Text(
                text = "Applications: ",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )
            Text(
                text = "87",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            )

        }

    }
}