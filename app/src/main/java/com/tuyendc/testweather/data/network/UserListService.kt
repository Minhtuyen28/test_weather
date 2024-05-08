package com.tuyendc.testweather.data.network

import com.tuyendc.testweather.data.database.WeatherItem
import retrofit2.http.GET

interface UserListService {

    @GET("/repos/square/retrofit/stargazers")
    suspend fun getUserList(): List<WeatherItem>
}