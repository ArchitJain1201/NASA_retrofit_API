package com.example.nasawalebhaiya.models

import java.time.Year

data class RecyclerList(val items: ArrayList<RecyclerData>)
data class RecyclerData(val earth_date: Date, val rover: Rover, val img_src: String)
data class Date(val day: Int, val month: Int, val year: Int )
data class Rover( val name: String, val landing_date: Date ,val launch_date: Date )