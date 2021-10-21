package com.navigationplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.navigationplayground.ui.theme.NavigationPlaygroundTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationPlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    Scaffold(bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "HOME",
                                    route = "home",
                                    icon = Icons.Default.Home,
                                    badgeCount = 0
                                ),
                                BottomNavItem(
                                    name = "CHAT",
                                    route = "chat",
                                    icon = Icons.Default.Notifications,
                                    badgeCount = 75
                                ),
                                BottomNavItem(
                                    name = "SETTINGS",
                                    route = "settings",
                                    icon = Icons.Default.Settings,
                                    badgeCount = 234
                                )
                            ),
                            navController = navController,
                            modifier = Modifier.padding(10.dp),
                            onItemClick = { item->
                                navController.navigate(item.route)
                            }
                        )
                    }) {
                        NavigationHost(navController = navController)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationPlaygroundTheme {
        Navigation()
    }
}