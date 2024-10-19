package com.preeti.assignment.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.preeti.assignment.viewModel.UserViewModel


@Composable
fun ListScreen(navController: NavController, sharedViewModel: SharedViewModel) {
    val viewModel: UserViewModel = hiltViewModel()
    Column() {
        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            var searchKey by remember {
                mutableStateOf("")
            }
            TextField(
                value = searchKey,
                onValueChange = {
                    searchKey = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(5.dp).shadow(5.dp),
                //.background(Blue),
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {
                    IconButton(onClick = {
                        viewModel.getUsers(searchKey)
                    }) {
                        Icon(
                            Icons.Filled.Search, "", tint = Color.Blue
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.LightGray,
                    focusedIndicatorColor = Color.Transparent, //hide the indicator
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
        var loadingg = viewModel.loading
        CircularIndeterminateProgressBar(isDisplayed = loadingg)
        UsersScreen(navController, sharedViewModel)
    }
}