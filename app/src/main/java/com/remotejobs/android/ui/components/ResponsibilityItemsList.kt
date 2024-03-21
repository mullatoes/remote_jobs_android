package com.remotejobs.android.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.remotejobs.android.R

@Composable
fun ResponsibilityItemsList(responsibilities: List<String>?) {
    if (responsibilities.isNullOrEmpty()) {
        Text(text = "No responsibilities provided")
    } else {
        responsibilities.forEachIndexed { index, responsibility ->
            ResponsibilityItem(
                icon = R.drawable.responsibility,
                text = responsibility
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun RequirementsItemsList(requirements: List<String>?) {
    if (requirements.isNullOrEmpty()) {
        Text(text = "No requirements provided")
    } else {
        requirements.forEachIndexed { index, responsibility ->
            ResponsibilityItem(
                icon = R.drawable.responsibility,
                text = responsibility
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun SkillsItemsList(skills: List<String>?) {
    if (skills.isNullOrEmpty()) {
        Text(text = "No skills provided")
    } else {
        skills.forEachIndexed { index, responsibility ->
            Text(
                text = responsibility,
                fontSize = 13.sp,
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}
