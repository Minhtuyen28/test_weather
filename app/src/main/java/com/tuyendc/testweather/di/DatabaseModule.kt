package com.tuyendc.testweather.di

import android.content.Context
import androidx.room.Room
import com.tuyendc.testweather.data.database.WeatherDao

import com.tuyendc.testweather.data.database.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): WeatherDatabase {
        return Room.databaseBuilder(
            appContext,
            WeatherDatabase::class.java,
            "Weather"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideChannelDao(weatherDatabase: WeatherDatabase): WeatherDao {
        return weatherDatabase.weatherDao
    }


}