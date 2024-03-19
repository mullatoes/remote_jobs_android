package com.remotejobs.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.AddTask
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.RemoveRedEye
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material.icons.rounded.TaskAlt
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.remotejobs.android.model.Job

@Composable
fun BottomSheetItem(
    job: Job,
    navController: NavController,
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier.clickable {
            onClick()
        },

        ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = job.title,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )

            Icon(Icons.Default.Share, contentDescription = null, tint = Color.Black)
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = job.company,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = job.companyCity,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = job.companyCountry,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = job.applications.toString(),
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
        }

        Row {
            Icon(
                Icons.Rounded.AttachMoney, contentDescription = null, tint = Color.Black,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = "Pay: ",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = "${job.payScaleMin}K - ${job.payScaleMax}K",
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = job.type,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = job.duration,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = job.experienceLevel,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
        }

        Row {
            Icon(
                Icons.Rounded.ShoppingBag, contentDescription = null, tint = Color.Black,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = "Company Size: ",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = "${job.noOfEmployeesLowBound} - ${job.noOfEmployeesHighBound} employees",
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = job.companyType,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
        }

        Row {
            Icon(
                Icons.Rounded.TaskAlt, contentDescription = null, tint = Color.Black,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = "Skills: ",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
            job.skills?.get(0)?.let {
                Text(
                    text = it,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(
                            horizontal = 10.dp,
                            vertical = 5.dp
                        )
                )
            }
            job.skills?.get(1)?.let {
                Text(
                    text = it,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(
                            horizontal = 10.dp,
                            vertical = 5.dp
                        )
                )
            }
            job.skills?.get(2)?.let {
                Text(
                    text = it,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(
                            horizontal = 10.dp,
                            vertical = 5.dp
                        )
                )
            }

        }

        Row {
            Icon(
                Icons.Rounded.RemoveRedEye, contentDescription = null, tint = Color.Black,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = "Views: ",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = job.views.toString(),
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )

        }

        Row {
            Icon(
                Icons.Rounded.AddTask, contentDescription = null, tint = Color.Black,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = "Applications: ",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
            Text(
                text = job.applications.toString(),
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )

        }

        Spacer(
            modifier =
            Modifier
                .height(20.dp)
        )

        Button(
            onClick = {
              navController.navigate("job_details_screen")
            }, modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Apply Now")
        }

    }
}