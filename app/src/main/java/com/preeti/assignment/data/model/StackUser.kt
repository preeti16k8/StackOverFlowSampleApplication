package com.preeti.assignment.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user_table")
data class StackUser(

@PrimaryKey(autoGenerate = true)
val account_id: Long?,

var badge_counts: Badge? = null,
val is_employee: Boolean?,
val last_modified_date: Long?,
val last_access_date: Long?,
val reputation_change_year: Int?,
val reputation_change_quarter: Int?,
val reputation_change_month: Int?,
val reputation_change_week: Int?,
val reputation_change_day: Int?,
val reputation: Int?,
val creation_date: Long?,
val user_type: String?,
val user_id: Long?,
val link: String?,
val profile_image: String?,
val display_name: String?

): Parcelable