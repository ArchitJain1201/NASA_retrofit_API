package com.example.nasawalebhaiya.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object{
        val BaseUrl = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=H3Lhv7biB6e9vVsQ5l3mUys8dggkbDIhV7ebwGgE"

        fun getRetroInstance(): Retrofit{
            return Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}