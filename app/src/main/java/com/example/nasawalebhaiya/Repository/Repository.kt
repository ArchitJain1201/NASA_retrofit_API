package com.example.nasawalebhaiya.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.nasawalebhaiya.models.NASA
import com.example.nasawalebhaiya.models.RecyclerData
import com.example.nasawalebhaiya.network.RetroInstance
import com.example.nasawalebhaiya.network.RetroService
import com.example.nasawalebhaiya.viewModel.RoomViewModel
import kotlinx.coroutines.GlobalScope
import retrofit2.Call
import retrofit2.Response

class MainActivityRepository {

    val TAG = MainActivityRepository::class.java.simpleName

    suspend fun getNASA(): List<NASA>{
        return RoomViewModel.database!!.NASADao().getAllNASA()
    }

    suspend fun PutInDB(response: RecyclerData){
        Log.e(TAG,response!!.toString())
        RoomViewModel.database!!.NASADao().deleteAllNASA()
        RoomViewModel.database!!.NASADao().insertAllNASA(response.photos.map { d-> NASA(d.camera.full_name, d.rover.name,d.img_src) })

        }
    }

