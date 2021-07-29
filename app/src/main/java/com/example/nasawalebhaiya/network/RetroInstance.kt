package com.example.nasawalebhaiya.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object{
        private const val BaseUrl = "https://api.nasa.gov/"

        fun getRetroInstance(): Retrofit{
            return Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}