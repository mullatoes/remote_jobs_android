package com.remotejobs.android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.RemoveRedEye
import androidx.compose.material.icons.rounded.TaskAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.remotejobs.android.model.Job

@Composable
fun JobDetailsScreen() {
    Column {
        Row {
            Icon(
                Icons.AutoMirrored.Rounded.ArrowBack,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 5.dp
                    )
            )

            Text(text = "Product Manager, Growth")

        }

        Text(
            text = "Product Manager, Growth", fontWeight =
            FontWeight.Bold
        )
        Text(text = "San Francisco, CA, Remote")
        Text(
            text = "Job Description", fontWeight =
            FontWeight.Bold
        )
        Text(
            text = "This is a hands-on role with primary focus on analysis, " +
                    "design, and development of complex business functionality. " +
                    "We are looking for Senior Java/J2ee developers with strong" +
                    " passion for developing quality code and deep understanding" +
                    " of core concepts of java/J2ee technologies. The ideal candidate" +
                    " would have deep experience with Java/J2ee ecosystem, " +
                    "well-versed in system design principles and proficient in " +
                    "designing and developing highly available, mission-critical " +
                    "applications. "
        )

        Text(
            text = "Responsibilities",
            fontWeight = FontWeight.Bold
        )
        Row {
            Icon(
                Icons.Rounded.TaskAlt,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 5.dp
                    )
            )

            Text(text = "Experience in growth marketing")
        }

        Row {
            Icon(
                Icons.Rounded.TaskAlt,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 5.dp
                    )
            )

            Text(text = "Experience with A/B Testing")
        }

        Text(
            text = "Requirements",
            fontWeight = FontWeight.Bold
        )
        Row {
            Icon(
                Icons.Rounded.TaskAlt,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 5.dp
                    )
            )

            Text(text = "Experience in growth marketing")
        }

        Row {
            Icon(
                Icons.Rounded.TaskAlt,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 5.dp
                    )
            )

            Text(text = "Experience with A/B Testing")
        }

        Text(
            text = "Benefits",
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
@Preview(
    showSystemUi = true,
    showBackground = true
)
fun JobDetailsScreenPreview(){
    JobDetailsScreen()
}