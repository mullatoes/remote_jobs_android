package com.remotejobs.android.ui.components

import Job
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.remotejobs.android.R
import com.remotejobs.android.util.AdMobUtil
import com.remotejobs.android.util.showMessage

import com.remotejobs.android.viewmodel.JobViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomSheetItem(
    job: Job,
    viewModel: JobViewModel,
    onClick: () -> Unit
) {

    val context = LocalContext.current

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
                modifier = Modifier.clickable {
                    shareJob(context, job)
                }
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
                text = "$${job.payScaleMin} - $${job.payScaleMax}",
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
                text = stringResource(R.string.company_size),
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
                text = stringResource(R.string.skills),
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
                text = stringResource(R.string.views),
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
                text = stringResource(R.string.applications),
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
            text = stringResource(R.string.about_the_job),
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = stringResource(R.string.job_description),
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
            text = stringResource(R.string.responsibilities),
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
            text = stringResource(R.string.requirements),
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

                AdMobUtil.showInterstitialAd(context,"ca-app-pub-3940256099942544/1033173712")

                val submitUrl = job.submitUrl
                showApplicationDialog(context,submitUrl){
                    viewModel.incrementApplicationNumber(job.jobId)
                }

            }, modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.submit_application))
        }

        Spacer(
            modifier =
            Modifier
                .height(40.dp)
        )

    }
}


fun shareJob(context: Context, job: Job) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        val message = "Hey friend, here is a job that might suit you: \"${job.title}\". Click here to apply: ${job.submitUrl}"
        shareIntent.putExtra(Intent.EXTRA_TEXT, message)
        context.startActivity(Intent.createChooser(shareIntent, "Share job via"))
}


fun showApplicationDialog(context: Context, submitUrl: String, onContinue: () -> Unit) {
    val builder = AlertDialog.Builder(context)
    builder.apply {
        setTitle(context.getString(R.string.dialog_title))
        setMessage(context.getString(R.string.dialog_message))
        setPositiveButton(context.getString(R.string.dialog_continue)) { dialog, _ ->
            dialog.dismiss()
            if (submitUrl.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(submitUrl))
                context.startActivity(intent)
                onContinue()
            } else {
                showMessage(context, context.getString(R.string.submit_url_not_available))
            }
        }
        setNegativeButton(context.getString(R.string.dialog_cancel)) { dialog, _ ->
            dialog.dismiss()
        }
        show()
    }
}