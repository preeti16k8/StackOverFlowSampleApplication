package repository
import utils.JSONHelper
import com.preeti.assignment.data.local.UserDao
import com.preeti.assignment.data.model.StackUser
import com.preeti.assignment.entity.GetStackUsers
import com.preeti.assignment.entity.LoginModel
import com.preeti.assignment.network.StackOverflowAPI
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StackOverflowUserRepository @Inject constructor(
     private val stackApi: StackOverflowAPI,
     private val db: UserDao
) {
     init {
          println("From Prod ")
     }
     fun  displayInfo() = "From Prod"
     suspend fun getUsers(name: String): GetStackUsers {
          return stackApi.getStackUsers(name)
     }

     suspend fun login(): Response<LoginModel> =  JSONHelper.fetchParsedJSONForLogin()

     fun getAllArticles() = db.getArticles()

     suspend fun insertArticle(article: StackUser) = db.insert(article)

}

