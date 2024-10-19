package com.preeti.assignment.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.preeti.assignment.data.model.StackUser
import com.preeti.assignment.data.model.Badge
import com.preeti.assignment.entity.ItemsData
import com.preeti.assignment.entity.LoadingState
import com.preeti.assignment.utils.checkForInternet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import repository.StackOverflowUserRepository
import javax.inject.Inject

@HiltViewModel
class UserViewModel@Inject constructor (private val repository: StackOverflowUserRepository) : ViewModel() {

    private val _getUserList = mutableStateListOf<ItemsData>()
    private var _getUserListFromDb = mutableStateListOf<StackUser>()
    val getUserListFromDb: List<StackUser>
        get() = _getUserListFromDb
    val getUserList: List<ItemsData>
        get() = _getUserList
    var errorMessage= MutableLiveData<String>()

   // val loading = mutableStateOf(true)
    var loading by mutableStateOf(
        LoadingState.State(
            isLoading = true
        )
    )

    init {
       // if (checkForInternet(this)) {
            viewModelScope.launch {
                getUsers("")
            }
      //  }
    }

    fun getUsers(name: String) {

        viewModelScope.launch {
            //loading.isLoading = true
            loading = loading.copy(isLoading = true)
            delay(1000)
            try {
                val response = repository.getUsers(name)
                _getUserList.clear()
                response.items?.let { _getUserList.addAll(it) }

                for (user in getUserList){
                    insertInDbCheck(StackUser(user.account_id, Badge(user.badge_counts?.bronze,user.badge_counts?.silver,
                        user.badge_counts?.gold),
                        user.is_employee,user.last_modified_date,user.last_access_date,user.reputation_change_year,
                        user.reputation_change_quarter,user.reputation_change_month,user.reputation_change_week,
                        user.reputation_change_day,user.reputation,user.creation_date,user.user_type,user.user_id,
                        user.link,user.profile_image,user.display_name))
                }
                loading = loading.copy(isLoading = false)
            }catch (e: Exception){
                e.printStackTrace()
                errorMessage.value = e.message.toString()
            }
        }
    }

    @DelicateCoroutinesApi
    fun getAllUsersFromDb() {

        GlobalScope.launch(Dispatchers.Main) {
            try {
                val userOne = async(Dispatchers.IO) { repository.getAllArticles() }.await()
                _getUserListFromDb.clear()
                _getUserListFromDb.addAll(userOne)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun searchList(name: String){

        viewModelScope.launch {
            try {
                val response = repository.getUsers(name)
                _getUserList.clear()
                response.items?.let { _getUserList.addAll(it) }
            }catch (e: Exception){
                e.printStackTrace()
                errorMessage.value = e.message.toString()
            }

        }
    }

    fun insertInDbCheck(article: StackUser){
        viewModelScope.launch {
            insertInDb(article)
        }
    }

    suspend fun insertInDb(user: StackUser) = repository.insertArticle(user)

    fun getFromDb(): List<StackUser> = repository.getAllArticles()
}