package com.preeti.assignment.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.preeti.assignment.entity.LoadingState
import com.preeti.assignment.entity.LoginStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import repository.StackOverflowUserRepository
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor (private val repository: StackOverflowUserRepository) : ViewModel() {
 //   var isLoggedInSuccess = false
    var errorMessage= MutableLiveData<String>()
  //  var state by mutableStateOf(isLoggedInSuccess)
    var isLoggedInState by mutableStateOf(
        LoginStateHolder.State(
            isLoggedInSuccess = false
        )
    )

    fun loginApi(){
        try {
            viewModelScope.launch {
                val usersResponse = repository.login()
                usersResponse.isSuccessful?.let {
                    Log.e("loginResponse", it.toString())
                    isLoggedInState = isLoggedInState.copy( isLoggedInSuccess = it)
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
            errorMessage.value = e.message.toString()
        }
    }

}
