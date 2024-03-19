package com.remotejobs.android.ui.components

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.remotejobs.android.ui.screens.AppliedJobsScreen
import com.remotejobs.android.ui.screens.JobsScreen
import com.remotejobs.android.ui.screens.ProfileScreen
import com.remotejobs.android.ui.screens.SavedJobsScreen
import com.remotejobs.android.ui.theme.BottomNavColor
import com.remotejobs.android.util.Screen
import com.remotejobs.android.viewmodel.JobViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomNavBar(navController: NavController) {
    val navigationController = rememberNavController()

    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = BottomNavColor
            ) {
                /*First Item*/
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navigationController.navigate(Screen.Home.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {

                    Icon(
                        Icons.Default.Home,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.LightGray else Color.DarkGray
                    )

                }

                /*Second Item*/

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.CheckCircle
                        navigationController.navigate(Screen.Saved.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {

                    Icon(
                        Icons.Default.CheckCircle,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.CheckCircle) Color.LightGray else Color.DarkGray
                    )

                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    FloatingActionButton(onClick = {
                        Toast.makeText(
                            context,
                            "FAB Clicked",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }) {
                        Icon(Icons.Default.Add, contentDescription = null, tint = Color.White)
                    }
                }

                /*Third Item*/

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Favorite
                        navigationController.navigate(Screen.Applications.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {

                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Favorite) Color.LightGray else Color.DarkGray
                    )

                }

                /*Fourth Item*/

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navigationController.navigate(Screen.Profile.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {

                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Person) Color.LightGray else Color.DarkGray
                    )

                }
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navigationController,
            startDestination = Screen.Home.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.screen) {
                JobsScreen(navController)
            }
            composable(Screen.Saved.screen) {
                SavedJobsScreen()
            }
            composable(Screen.Applications.screen) {
                AppliedJobsScreen()
            }
            composable(Screen.Profile.screen) {
                ProfileScreen()
            }

        }
    }
}