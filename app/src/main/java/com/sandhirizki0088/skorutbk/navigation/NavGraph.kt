package com.sandhirizki0088.skorutbk.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sandhirizki0088.skorutbk.ui.screen.AboutScreen
import com.sandhirizki0088.skorutbk.ui.screen.MainScreen

@Composable
fun SetUpNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            MainScreen()
        }

        composable(route = Screen.About.route) {
            AboutScreen()

        }
    }
}