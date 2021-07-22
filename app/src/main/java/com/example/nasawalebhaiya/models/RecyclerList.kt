package com.example.nasawalebhaiya.models

import java.time.Year

data class RecyclerList(val items: ArrayList<RecyclerData>)
data class RecyclerData(val photo: Photo)
data class Photo(val camera: Camera, val rover: Rover, val img_src: String)
data class Rover( val name: String )
data class Camera(val full_name: String)