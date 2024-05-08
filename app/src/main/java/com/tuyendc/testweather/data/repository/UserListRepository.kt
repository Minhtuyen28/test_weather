package com.tuyendc.testweather.data.repository

import androidx.lifecycle.LiveData
import com.tuyendc.testweather.data.database.WeatherDatabase
import com.tuyendc.testweather.data.database.WeatherItem
import com.tuyendc.testweather.data.network.UserListService
import javax.inject.Inject

class UserListRepository @Inject constructor(
    private val userListService: UserListService,
    private val database: WeatherDatabase,
) {

    val users: LiveData<List<WeatherItem>> =
        database.weatherDao.getDatabaseWeather()

    suspend fun refreshUserList() {
        try {
            val listWeather = userListService.getUserList()
            database.weatherDao.insertAll(listWeather)
        } catch (e: Exception) {

        }
    }
}