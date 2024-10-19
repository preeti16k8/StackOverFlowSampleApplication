package com.preeti.assignment.screens
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.preeti.assignment.Path
import com.preeti.assignment.R
import com.preeti.assignment.ui.theme.Purple700
import com.preeti.assignment.viewModel.LoginViewModel

@Composable
fun LoginPage(navController: NavHostController) {
    val viewModel: LoginViewModel = hiltViewModel()
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            text = AnnotatedString("Sign up here"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = { navController.navigate(Path.SignUp.route) },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = Purple700
            )
        )
    }
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val username = rememberSaveable(stateSaver = TextFieldValue.Saver) { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }

        var errorStateForUsername by remember { mutableStateOf(false) }
        var errorStateForPassword by remember { mutableStateOf(false) }
        var errorMessageForUsername by remember { mutableStateOf("") }
        var errorMessageForPassword by remember { mutableStateOf("") }
        val context = LocalContext.current



        Image(painter = painterResource(id = R.drawable.stack), contentDescription = "",
            Modifier
                .fillMaxWidth()
                .height(100.dp))

        Text(text = "Login to StackOverFlow", style = TextStyle(fontSize = 20.sp,
            fontFamily = FontFamily.Monospace, color = Color.Red))

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Username") },
            value = username.value,
            onValueChange = { username.value = it
                when {
                    username.value.text.isEmpty() -> {
                        errorStateForUsername = true
                        errorMessageForUsername = "Please enter the username!"
                    }
                    username.value.text.startsWith("0") -> {
                        errorStateForUsername = true
                        errorMessageForUsername = "Name should not start with zero!"
                    }
                    else -> {
                        errorStateForUsername = false
                        errorMessageForUsername = ""
                    }
                  }
                },
            isError = errorStateForUsername,
            trailingIcon = {
                if (errorStateForUsername)
                    //Icon(Icons.Rounded.Warning, errorMessageForUsername, tint = MaterialTheme.colors.error)
                   Icon(Icons.Sharp.Star, errorMessageForUsername, tint = MaterialTheme.colors.error)
               }
            )
        if (errorStateForUsername) {
            Text(
                text = errorMessageForUsername, color = Color.Red, modifier = Modifier
                    .padding(10.dp, 0.dp, 0.dp, 0.dp)
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Password") },
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it
                when {
                    password.value.text.isEmpty() -> {
                        errorStateForPassword = true
                        errorMessageForPassword = "Please enter the Password!"
                    }
                    password.value.text.length < 6 -> {
                        errorStateForPassword = true
                        errorMessageForPassword = "Password length should be 6 or more than 6 characters."
                    }
                    else -> {
                        errorStateForPassword = false
                        errorMessageForPassword = ""
                    }
                }
            },
            isError = errorStateForPassword,
            trailingIcon = {
                if (errorStateForPassword)
                    Icon(Icons.Sharp.Star, "error", tint = MaterialTheme.colors.error)
            }
        )
        if (errorStateForPassword) {
            Text(
                text = errorMessageForPassword, color = Color.Red, modifier = Modifier
                    .padding(10.dp, 0.dp, 0.dp, 0.dp)
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = { //navController.navigate(Path.Dashboard.route)
                    when {
                        username.value.text.isEmpty() -> {
                            errorStateForUsername = true
                        }
                        password.value.text.isEmpty() -> {
                            errorStateForPassword = true
                        }
                        password.value.text.length<8 -> {
                            errorStateForPassword = true
                        }
                        else -> {
                            viewModel.loginApi()
                            if(viewModel.isLoggedInState.isLoggedInSuccess){
                             /*   val intent = Intent(context, UserActivity::class.java)
                                context.startActivity(intent)*/
                                navController.navigate(Path.Dashboard.route)
                            }
                          }
                        }
                    },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}
