package com.tuyendc.testweather

import android.app.Application
import androidx.lifecycle.LiveData
import com.tuyendc.testweather.base.BaseViewModel
import com.tuyendc.testweather.data.database.WeatherItem
import com.tuyendc.testweather.data.repository.UserListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    var repository: UserListRepository
) : BaseViewModel(application) {

    var listWeather: LiveData<List<WeatherItem>> = repository.users


    fun getListWeather() {
        launchDataLoadWithoutProgress {
            repository.refreshUserList()
        }
    }
}