package com.example.nasawalebhaiya.models


import androidx.room.Entity
import androidx.room.PrimaryKey


data class RecyclerData(val photos: ArrayList<Photos>)
data class Photos(
    val camera: Camera,
    val rover: Rover,
    val img_src: String
    )
data class Rover( val name: String )
data class Camera(val full_name: String)

@Entity(tableName = "NASA")
data class NASA(
    val cameraName: String,
    val roverName: String,
    val imgSrc: String
){
    @PrimaryKey(autoGenerate = true)
    val id: Int=0
}