package com.example.nasawalebhaiya.viewModel

import android.app.Application
import androidx.room.Room
import com.example.nasawalebhaiya.Room.NASADatabase



class RoomViewModel: Application(){

    companion object{
        var database: NASADatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(applicationContext, NASADatabase::class.java, "NASA.db").fallbackToDestructiveMigration().build()
    }
}