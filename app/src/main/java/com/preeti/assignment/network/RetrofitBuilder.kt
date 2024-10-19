package com.preeti.assignment.network
import com.preeti.assignment.constants.ApiConstant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(ApiConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: StackOverflowAPI by lazy{
        retrofit.create(StackOverflowAPI::class.java)
    }
}