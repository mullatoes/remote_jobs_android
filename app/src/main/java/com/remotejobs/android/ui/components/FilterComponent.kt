package com.remotejobs.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.remotejobs.android.R

@Composable
fun FilterComponent(onFilterClick: () -> Unit) {
    LazyRow {
        item {

            Image(
                painter = painterResource(id = R.drawable.sort),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .clickable {
                        onFilterClick()
                    }
            )

        }
        item {
            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .background(
                        MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(4.dp)
                    )
            ) {
                Text(
                    text = "Sort By",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        item {
            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .background(
                        MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(4.dp)
                    )
            ) {
                Text(
                    text = "Region",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        item {
            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .background(
                        MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(4.dp)
                    )
            ) {
                Text(
                    text = "Specialization",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        item {
            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .background(
                        MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(4.dp)
                    )
            ) {
                Text(
                    text = "Experience",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
