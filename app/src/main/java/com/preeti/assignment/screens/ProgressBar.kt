package com.preeti.assignment.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.preeti.assignment.entity.LoadingState

@Composable
fun CircularProgressBarDemo() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            progress = 0.5f,
            color = Color.Magenta,
            strokeWidth=12.dp,
        )
    }
}

@Composable
fun CircularIndeterminateProgressBar(isDisplayed: LoadingState.State) {
    if (isDisplayed.isLoading) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary
            )
        }
    }
}