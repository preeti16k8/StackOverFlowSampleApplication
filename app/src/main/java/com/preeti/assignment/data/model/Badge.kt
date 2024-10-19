package com.preeti.assignment.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Badge(
    val bronze: Int?,
    val silver: Int?,
    val gold: Int?

):Parcelable

