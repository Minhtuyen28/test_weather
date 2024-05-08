package com.tuyendc.testweather.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WeatherDao {

    // user List
    @Query("select * from WeatherItem")
    fun getDatabaseWeather(): LiveData<List<WeatherItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(weathers: List<WeatherItem>)

}

@Database(entities = [WeatherItem::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {
    abstract val weatherDao: WeatherDao
}