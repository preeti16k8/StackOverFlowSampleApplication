package com.preeti.assignment.screens
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.preeti.assignment.Path

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Path.Login.route) {

        composable(Path.Login.route) {
            LoginPage(navController = navController)
        }
        composable(Path.SignUp.route) {
            SignUp(navController = navController)
        }
        composable(Path.Dashboard.route) {
            Dashboard(navController = navController)
        }
    }
}