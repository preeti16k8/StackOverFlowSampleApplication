package com.preeti.assignment.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.preeti.assignment.entity.ItemsData

class SharedViewModel: ViewModel() {

    var user by mutableStateOf<ItemsData?>(null)
    private set

    fun addUser(newUser: ItemsData){
        user = newUser
    }
}