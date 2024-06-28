package com.remotejobs.android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.google.firebase.auth.FirebaseUser
import com.remotejobs.android.R
import com.remotejobs.android.ui.components.TopAppBarWithTextAndImage
import com.remotejobs.android.ui.navigation.SignIn
import com.remotejobs.android.viewmodel.ProfileViewModel
import com.remotejobs.android.viewmodel.UserViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel,
    userViewModel: UserViewModel) {

    val user = userViewModel.user.value


    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {


//            ProfileAppBar(title = "Profile", icon = R.drawable.backarrow) {
//                navController.popBackStack()
//            }
            Spacer(modifier = Modifier.height(16.dp))
            if (user != null){
                UserInfo(user = userViewModel.user.value)
                Spacer(modifier = Modifier.weight(1f))
                LogoutButton(userViewModel,navController)
            }else{
                UserNotSignedIn(navController = navController)
            }
           
    }

}

@Composable
fun UserInfo(user: FirebaseUser?) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        UserCard(user = user)
    }
}


@Composable
fun UserCard(user: FirebaseUser?) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                if (user?.photoUrl != null) {
                    Image(
                        modifier = Modifier.size(50.dp),
                        painter = rememberImagePainter(user.photoUrl),
                        contentDescription = "Profile Picture"
                    )
                } else {
                    Icon(
                        modifier = Modifier.size(50.dp),
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Profile Placeholder"
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = user?.displayName ?: "Not Provided",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = Icons.Outlined.Email,
                    contentDescription = "Email Icon"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Email: ${user?.email ?: "Not Provided"}")
            }
           
        }
    }
}

@Composable
fun NotificationsCard() {
   
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Notifications",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            
        }
    }
}


@Composable
fun ProfileAppBar(title: String, icon: Int, onBackClicked: () -> Unit) {
    TopAppBarWithTextAndImage(
        title = title,
        icon = icon
    )
}

@Composable
fun LogoutButton(
    userViewModel: UserViewModel,
    navController: NavController
) {
    Button(
        onClick = {
            userViewModel.logOut()
            navController.navigate(SignIn.route){
                popUpTo(SignIn.route){
                    inclusive = true
                }
            }
                  },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Text(text = "Logout", color = Color.White)
    }
}

@Composable
fun UserNotSignedIn(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.primary 
            )

            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "Log into existing account",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))
            
            Button(
                onClick = {
                    navController.navigate(SignIn.route)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Login")
            }
        }
    }
}
