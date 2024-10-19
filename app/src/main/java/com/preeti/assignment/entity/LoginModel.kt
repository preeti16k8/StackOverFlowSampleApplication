package com.preeti.assignment.entity

import com.google.gson.annotations.SerializedName

data class LoginModel (

    @SerializedName("response")
    var response: List<Response>? = null,
    @SerializedName("twoFactorId")
    var profileImage: String? = null
)

data class Response (
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("username")
    var username: String? = null,
    @SerializedName("userid")
    var userid: String? = null
)