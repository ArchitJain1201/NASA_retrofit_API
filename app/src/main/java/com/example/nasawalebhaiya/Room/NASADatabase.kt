package com.example.nasawalebhaiya.Room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nasawalebhaiya.models.NASA

@Database(entities = [(NASA::class)], version = 1)
abstract class NASADatabase: RoomDatabase(){
    abstract fun NASADao(): NASADao
}