package com.preeti.assignment.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.preeti.assignment.BottomNavItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Dashboard(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                CustomTopAppBar(navController, "Welcome !", true)
            },
            bottomBar = {
                BottomNavigationBar(
                    items = listOf(
                        BottomNavItem(
                            name = "Users",
                            route = "users",
                            icon = Icons.Default.Person
                        ),
                        BottomNavItem(
                            name = "Search",
                            route = "search",
                            icon = Icons.Default.Search
                            //   badgeCount = 23
                        ),
                    ),
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route)
                    }
                )
            }
        ) {
            NavigationInDashBoard(navController = navController)
        }
    }
}
