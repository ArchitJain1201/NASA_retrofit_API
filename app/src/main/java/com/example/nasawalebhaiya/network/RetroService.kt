package com.example.nasawalebhaiya.network

import com.example.nasawalebhaiya.models.RecyclerData
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1&api_key=H3Lhv7biB6e9vVsQ5l3mUys8dggkbDIhV7ebwGgE")
    suspend fun getDataFromApi(@Query("q") query: String): RecyclerData
}