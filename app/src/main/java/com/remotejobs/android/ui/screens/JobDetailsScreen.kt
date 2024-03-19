import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.remotejobs.android.R
import com.remotejobs.android.ui.components.RequirementItem
import com.remotejobs.android.ui.components.ResponsibilityItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobDetailsScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        TopAppBar(
            title = { Text(text = "Staff Android Engineer") },
            navigationIcon = {
                IconButton(onClick = {

                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Staff Android Engineer",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "San Francisco, CA, Remote",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 25.dp)
        )

        Text(
            text = "Job Description",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        val longDescription = "As a Staff Android Engineer in Guest Displays & Platforms, you’ll " +
                "lead the development and refinement of major new features at the heart of the " +
                "guest experience on Airbnb. This includes reconciling new features with existing " +
                "functionality, working closely with designers to shape desired product goals into " +
                "a feasible and viable guest user experience, and last but not least, identifying " +
                "underlying patterns and abstractions to help increase developer velocity while " +
                "maintaining technical quality on critical surfaces for the Airbnb guest experience."

        Text(
            text = AnnotatedString.Builder().apply {
                append(longDescription)
            }.toAnnotatedString(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Responsibilities",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        ResponsibilityItem(
            icon = R.drawable.responsibility,
            text = "Design the future state of our technical systems by combining a strategic" +
                    " understanding of our highest level product goals with a deep understanding" +
                    " of our existing systems to inform the right technical and product tradeoffs" +
                    " for both short and long term"
        )
        Spacer(modifier = Modifier.height(10.dp))
        ResponsibilityItem(
            icon = R.drawable.responsibility,
            text = "Lead engineers—both inside and outside your immediate team—in building out " +
                    "these technical solutions"
        )
        Spacer(modifier = Modifier.height(10.dp))
        ResponsibilityItem(
            icon = R.drawable.responsibility,
            text = "Participate in the development of product and UX requirements by engaging early" +
                    " and often with designers, product managers and other stakeholders to help " +
                    "steer teams on the most efficient path towards overall goals"
        )
        Spacer(modifier = Modifier.height(10.dp))
        ResponsibilityItem(
            icon = R.drawable.responsibility,
            text = "Nurture a culture of technical quality from design, through code review, " +
                    "to production operations"
        )
        Spacer(modifier = Modifier.height(10.dp))
        ResponsibilityItem(
            icon = R.drawable.responsibility,
            text = "Mentor other engineers in developing their technical and collaboration skills"
        )
        Spacer(modifier = Modifier.height(10.dp))
        ResponsibilityItem(
            icon = R.drawable.responsibility,
            text = "Identify and propose solutions to problems coming in the way of technical and" +
                    " product engineering excellence"
        )
        Spacer(modifier = Modifier.height(10.dp))
        ResponsibilityItem(
            icon = R.drawable.responsibility,
            text = "Collaborate with internal teams across Search, Checkout, Reservations, " +
                    "Host Settings, Listings, Payments, Tax, Cities, Trust and others"
        )

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

        RequirementItem(
            icon = R.drawable.responsibility,
            text = "9+ years of industry experience building consumer Android applications at scale," +
                    " preferably in Kotlin and Compose."
        )
        Spacer(modifier = Modifier.height(10.dp))
        RequirementItem(
            icon = R.drawable.responsibility,
            text = "You’re passionate about UI and Product development: deep knowledge of UI " +
                    "architecture and UI performance, with prior experience building delightful " +
                    "and fluid interactions, screens and graphics."
        )
        Spacer(modifier = Modifier.height(10.dp))
        RequirementItem(
            icon = R.drawable.responsibility,
            text = "Expertise in Kotlin or Java, and Jetpack Compose."
        )
        Spacer(
            modifier =
            Modifier.height(10.dp)
        )
        RequirementItem(
            icon = R.drawable.responsibility,
            text = "Ability to take a thoughtful, pragmatic, and efficient approach to problem " +
                    "solving."
        )
        Spacer(modifier = Modifier.height(10.dp))
        RequirementItem(
            icon = R.drawable.responsibility,
            text = "Experience collaborating with product designers, especially in a remote " +
                    "capacity."
        )
        Spacer(modifier = Modifier.height(10.dp))
        RequirementItem(
            icon = R.drawable.responsibility,
            text = "Passion to up-level yourself and those around you through curiosity and " +
                    "fostering a collaborative and inclusive team environment."
        )
        Spacer(modifier = Modifier.height(10.dp))
        RequirementItem(
            icon = R.drawable.responsibility,
            text = "Bachelors, preferably in CS, or equivalent industry experience."
        )

        Spacer(
            modifier =
            Modifier
                .height(30.dp)
        )

        Button(
            onClick = {

            }, modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Submit Application")
        }

    }
}


@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun JobDetailsPreview() {
    JobDetailsScreen()
}
