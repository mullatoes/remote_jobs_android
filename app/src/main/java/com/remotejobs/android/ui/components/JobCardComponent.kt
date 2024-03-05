package com.remotejobs.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.remotejobs.android.model.Job
import com.remotejobs.android.ui.screens.JobsScreen

@Composable
fun JobCardComponent(image: String, title: String, type: String) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )

            Spacer(Modifier.size(16.dp))

            Column {
                Text(
                    text = title,
                    fontSize = 13.sp
                )
                Text(
                    text = type,
                    fontSize = 10.sp
                )
            }
        }

        Button(onClick = {

        }) {
            Text(text = "Apply")
        }
    }
}

@Composable
fun JobCardList(jobs: List<Job>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(jobs) { job ->
            JobCardComponent(
                image = job.companyLogo,
                title = job.title,
                type = job.type
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun JobCardComponentPreview() {
    // JobCardComponent(image = "https://media.licdn.com/dms/image/C560BAQH9qeI8ekCATA/company-logo_200_200/0/1646788525018/wonders_corporation_logo?e=1717632000&v=beta&t=uhdiDVY9jL6yEvT5sTJfOF6DwSCA9pkgBJJ7SH6fHF0", title = "Android Developer", type = "remote")
}