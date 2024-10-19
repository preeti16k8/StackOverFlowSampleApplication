package com.preeti.assignment.network

import com.preeti.assignment.constants.ApiConstant.GET_STACK_USER
import com.preeti.assignment.entity.GetStackUsers
import retrofit2.http.GET
import retrofit2.http.Query

interface StackOverflowAPI {

    @GET(GET_STACK_USER)
    suspend fun getStackUsers(@Query(NAME) name: String?): GetStackUsers

    companion object {
        const val NAME = "inname"
    }
}