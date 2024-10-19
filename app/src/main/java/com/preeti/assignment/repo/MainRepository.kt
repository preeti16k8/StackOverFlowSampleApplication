package com.preeti.assignment.repo
import com.preeti.assignment.data.local.UserDao
import com.preeti.assignment.data.model.StackUser
import com.preeti.assignment.entity.GetStackUsers
import com.preeti.assignment.network.RetrofitBuilder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository@Inject constructor (private val db: UserDao) {
    suspend fun getUsers(name: String): GetStackUsers {
        return RetrofitBuilder.apiService.getStackUsers(name)
    }

   /* suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    suspend fun getUserFromDb() = db.getUserDao().getuser()


*/

    fun getAllArticles() = db.getArticles()

    suspend fun insertArticle(article: StackUser) = db.insert(article)

}