package utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.preeti.assignment.UserApplication
import com.preeti.assignment.entity.LoginModel
import retrofit2.Response
import java.lang.reflect.Type

object JSONHelper {

    fun fetchParsedJSONForLogin(): Response<LoginModel> {
        var jsonfile: String = ""
        jsonfile= UserApplication.instance.applicationContext.assets.open("login.json").bufferedReader().use {it.readText()}

        //   println("Parsed JSON file is.... $jsonfile")
        val gson = Gson()
        val shelfSequenceTypesModelType: Type = object : TypeToken<LoginModel>() {}.type
        var shelfSequenceTypeModel = gson.fromJson<LoginModel>(jsonfile,shelfSequenceTypesModelType)
        //   println("OpenShelfSequenceModel in String ${shelfSequenceTypeModel.toString()}")
        return  Response.success(shelfSequenceTypeModel)
    }
}