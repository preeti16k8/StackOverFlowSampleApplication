package com.preeti.assignment.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.preeti.assignment.constants.ApiConstant
import com.preeti.assignment.data.model.StackUser

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SearchScreenFromDb(userList: List<StackUser>) {
    val scrollState = rememberScrollState()
    LaunchedEffect(Unit) { scrollState.animateScrollTo(10000) }
    val context = LocalContext.current

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(userList) { user ->
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clickable {
                      /*  val intent = Intent(context, UserDetailsActivity::class.java)
                        intent.putExtra(ApiConstant.USER_DATA, user)
                        context.startActivity(intent)*/
                    }
            ) {
                Column {
                    Image(
                        painter = rememberImagePainter(user.profile_image),
                        contentDescription = null,
                        modifier = Modifier
                            // .fillMaxWidth()
                            // .height(110.dp)
                            .size(64.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                            .align(Alignment.CenterHorizontally)
                    )
                    CommonTextView(user.display_name.toString())
                    CommonTextView("Reputation:" + " "+ user.reputation.toString())

                }
            }
        }
    }
}