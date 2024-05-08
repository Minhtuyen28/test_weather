package com.tuyendc.testweather.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherItem constructor(
    @PrimaryKey
    val id: Int,
    val avatar: String,
    val username: String
)

