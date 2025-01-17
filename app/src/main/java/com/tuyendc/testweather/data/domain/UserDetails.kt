package com.tuyendc.testweather.data.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDetails(
    val user: String? = "",
    val avatar: String? = "",
    val name: String? = "",
    val userSince: String? = "",
    val location: String? = ""
) : Parcelable