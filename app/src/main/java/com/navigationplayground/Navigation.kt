package com.navigationplayground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
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
        composable(Screens.ScreenDetail.route){
            DetailScreen(navController = navController)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("HOME")
        Button(onClick = {
            navController.navigate(Screens.ScreenDetail.route)
        }) {
            Text(text = "DETAIL")
        }
    }
}

@Composable
fun DetailScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("DETAIL")
        Button(onClick = {
            navController.navigate(Screens.ScreenHome.route)
        }) {
            Text(text = "HOME")
        }
    }
}
