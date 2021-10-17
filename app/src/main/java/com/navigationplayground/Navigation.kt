package com.navigationplayground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.ScreenHome.route) {
        composable(Screens.ScreenHome.route) {
            HomeScreen(navController)
        }

        composable(route = Screens.ScreenDetail.route+"/{name}", arguments = listOf(navArgument("name") {
            type = NavType.StringType
            defaultValue = "Raphael"
        })) { entry ->
            DetailScreen(navController = navController, name = entry.arguments?.getString("name")!!)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = text, onValueChange = {
            text = it
        })
        Button(onClick = {
            navController.navigate(Screens.ScreenDetail.route+"/$text")
        }) {
            Text(text = "DETAIL")
        }
    }
}

@Composable
fun DetailScreen(navController: NavController, name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(name)
        Button(onClick = {
            navController.navigate(Screens.ScreenHome.route)
        }) {
            Text(text = "HOME")
        }
    }
}
