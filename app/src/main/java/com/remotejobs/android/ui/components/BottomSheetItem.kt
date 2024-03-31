package com.remotejobs.android.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.remotejobs.android.R
import com.remotejobs.android.model.Job
import com.remotejobs.android.viewmodel.JobViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomSheetItem(
    job: Job,
    viewModel: JobViewModel,
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
            )

            Icon(
                Icons.Default.Share,
                contentDescription = null,
                tint = Color.Black,
            )
        }

        Spacer(
            modifier =
            Modifier
                .height(10.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = job.company,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier =
                Modifier.width(10.dp)
            )
            Text(
                text = job.companyCity,
                fontSize = 15.sp,

                )
            Spacer(
                modifier =
                Modifier.width(10.dp)
            )
            Text(
                text = job.companyCountry,
                fontSize = 15.sp,
            )
            Spacer(
                modifier =
                Modifier.width(10.dp)
            )
            Text(
                text = "${job.applications.toString()} applications",
                fontSize = 15.sp,
            )
        }
        Spacer(
            modifier =
            Modifier
                .height(10.dp)
        )

        Row {
            Image(
                painter = painterResource(id = R.drawable.pay),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(
                modifier =
                Modifier.width(10.dp)
            )
            Text(
                text = "Pay: ",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(
                modifier =
                Modifier.width(5.dp)
            )
            Text(
                text = "${job.payScaleMin}K - ${job.payScaleMax}K",
                fontSize = 13.sp,
            )
            Spacer(
                modifier =
                Modifier.width(5.dp)
            )
            Text(
                text = job.type,
                fontSize = 13.sp,
            )
            Spacer(
                modifier =
                Modifier.width(5.dp)
            )
            Text(
                text = job.duration,
                fontSize = 13.sp,
            )
            Spacer(
                modifier =
                Modifier.width(5.dp)
            )
            Text(
                text = job.experienceLevel,
                fontSize = 13.sp,
            )
        }
        Spacer(
            modifier =
            Modifier
                .height(10.dp)
        )

        Row {
            Image(
                painter = painterResource(id = R.drawable.companysize),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(
                modifier =
                Modifier.width(10.dp)
            )
            Text(
                text = "Company Size: ",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(
                modifier =
                Modifier.width(5.dp)
            )
            Text(
                text = "${job.noOfEmployeesLowBound} - ${job.noOfEmployeesHighBound} employees",
                fontSize = 13.sp,
            )
            Spacer(
                modifier =
                Modifier.width(5.dp)
            )
            Text(
                text = job.companyType,
                fontSize = 13.sp,

                )
        }
        Spacer(
            modifier =
            Modifier
                .height(10.dp)
        )

        Row {
            Image(
                painter = painterResource(id = R.drawable.skills),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(
                modifier =
                Modifier.width(10.dp)
            )
            Text(
                text = "Skills: ",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(
                modifier =
                Modifier.width(5.dp)
            )
            SkillsItemsList(skills = job.skills)

        }
        Spacer(
            modifier =
            Modifier
                .height(10.dp)
        )

        Row {
            Image(
                painter = painterResource(id = R.drawable.eyes),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(
                modifier =
                Modifier.width(10.dp)
            )
            Text(
                text = "Views: ",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,

                )
            Spacer(
                modifier =
                Modifier.width(5.dp)
            )
            Text(
                text = job.views.toString(),
                fontSize = 13.sp,

                )

        }
        Spacer(
            modifier =
            Modifier
                .height(10.dp)
        )

        Row {
            Image(
                painter = painterResource(id = R.drawable.applications),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(
                modifier =
                Modifier.width(10.dp)
            )
            Text(
                text = "Applications: ",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,

                )
            Spacer(
                modifier =
                Modifier.width(5.dp)
            )
            Text(
                text = job.applications.toString(),
                fontSize = 13.sp,

                )

        }

        Spacer(
            modifier =
            Modifier
                .height(20.dp)
        )

        Divider(color = Color.Black, thickness = 3.dp)

        Spacer(
            modifier =
            Modifier
                .height(30.dp)
        )

        Text(
            text = "About the job",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Job Description",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = AnnotatedString.Builder().apply {
                append(job.description)
            }.toAnnotatedString(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Responsibilities",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        ResponsibilityItemsList(responsibilities = job.responsibilities)

        Spacer(
            modifier =
            Modifier
                .height(30.dp)
        )

        Text(
            text = "Requirements",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        RequirementsItemsList(requirements = job.niceToHaveSkills)

        Spacer(
            modifier =
            Modifier
                .height(30.dp)
        )

        Button(
            onClick = {

                      viewModel.incrementApplicationNumber(job.jobId)

            }, modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Submit Application")
        }

        Spacer(
            modifier =
            Modifier
                .height(40.dp)
        )

    }
}