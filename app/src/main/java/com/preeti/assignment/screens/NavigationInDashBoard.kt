package com.preeti.assignment.screens
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.preeti.assignment.viewModel.UserViewModel
import kotlinx.coroutines.DelicateCoroutinesApi


@OptIn(DelicateCoroutinesApi::class)
@Composable
fun NavigationInDashBoard(navController: NavHostController
) {
    val sharedViewModel: SharedViewModel = viewModel()
    val viewModel: UserViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = "users") {
        composable("users") {
            //UsersScreen(userList)
            ListScreen(navController = navController, sharedViewModel = sharedViewModel)
        }
        composable("search") {
            viewModel.getAllUsersFromDb()
            SearchScreenFromDb(viewModel.getUserListFromDb)
        }
        composable("userDetails") {
            UsersDetailsScreen(navController = navController, sharedViewModel = sharedViewModel)
        }
    }
}
