package com.preeti.assignment.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GetStackUsers(
    @SerializedName("items")
    var items: List<ItemsData>? = null,

    @SerializedName("has_more")
    val has_more: Boolean?,

    @SerializedName("quota_max")
    val quota_max: Long?,

    @SerializedName("quota_remaining")
    val quota_remaining: Long?
)

data class ItemsData(
    @SerializedName("badge_counts")
    var badge_counts: BadgeCount? = null,

    @SerializedName("account_id")
    val account_id: Long?,

    @SerializedName("is_employee")
    val is_employee: Boolean?,

    @SerializedName("last_modified_date")
    val last_modified_date: Long?,

    @SerializedName("last_access_date")
    val last_access_date: Long?,

    @SerializedName("reputation_change_year")
    val reputation_change_year: Int?,

    @SerializedName("reputation_change_quarter")
    val reputation_change_quarter: Int?,

    @SerializedName("reputation_change_month")
    val reputation_change_month: Int?,

    @SerializedName("reputation_change_week")
    val reputation_change_week: Int?,

    @SerializedName("reputation_change_day")
    val reputation_change_day: Int?,

    @SerializedName("reputation")
    val reputation: Int?,

    @SerializedName("creation_date")
    val creation_date: Long?,

    @SerializedName("user_type")
    val user_type: String?,

    @SerializedName("user_id")
    val user_id: Long?,

    @SerializedName("link")
    val link: String?,

    @SerializedName("profile_image")
    val profile_image: String?,

    @SerializedName("display_name")
    val display_name: String?
):Serializable

data class BadgeCount(
    @SerializedName("bronze")
    val bronze: Int?,

    @SerializedName("silver")
    val silver: Int?,

    @SerializedName("gold")
    val gold: Int?
):Serializable
