package com.example.nasawalebhaiya.models

import java.time.Year


data class RecyclerData(val photos: ArrayList<Photos>)
data class Photos(val camera: Camera, val rover: Rover, val img_src: String)
data class Rover( val name: String )
data class Camera(val full_name: String)