package com.preeti.assignment.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun UsersDetailsScreen(navController: NavController, sharedViewModel: SharedViewModel) {
    // val user: ItemsData
    val user = sharedViewModel.user
    val scrollState = rememberScrollState()
    LaunchedEffect(Unit) { scrollState.animateScrollTo(10000) }
    Spacer(modifier = Modifier.height(40.dp))
    Text("User Details: ",style = TextStyle(fontSize = 20.sp,
        fontFamily = FontFamily.SansSerif, color = Color.Blue, fontStyle = FontStyle.Normal ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), textAlign = TextAlign.Center)

    Column(modifier = Modifier
        .padding(vertical = 20.dp)
        .verticalScroll(scrollState)) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(60.dp)
                .fillMaxWidth()
        ) {
            Column {
                Image(
                    painter = rememberImagePainter(user?.profile_image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                )
                CommonTextView("Name:" + " " +user?.display_name.toString())
                CommonTextView("Reputation:" + " "+ user?.reputation.toString())
                CommonTextView("Silver Badge:" + " "+ user?.badge_counts?.silver)
                CommonTextView("Gold Badge:" + " "+ user?.badge_counts?.gold)
                CommonTextView("Bronze Badge:" + " "+ user?.badge_counts?.bronze)
                CommonTextView("Account Id:" + " "+ user?.account_id)
                CommonTextView("User Id:" + " "+ user?.user_id)
                CommonTextView("User Type:" + " "+ user?.user_type)
                //   CommonTextView("Creation Date:" + " "+ user.creation_date)
                //   CommonTextView("Reputation Change Year:" + " "+ user.reputation_change_year)
            }

        }
    }
}

