package com.example.nasawalebhaiya.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasawalebhaiya.models.RecyclerList
import com.example.nasawalebhaiya.network.RetroInstance
import com.example.nasawalebhaiya.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class MainActivityViewModel: ViewModel() {
    lateinit var recyclerListLiveData: MutableLiveData<RecyclerList>
    init {
        recyclerListLiveData = MutableLiveData()
    }
    fun getRecyclerListObserver(): MutableLiveData<RecyclerList>{
        return recyclerListLiveData
    }
    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getDataFromApi("ny")
            recyclerListLiveData.postValue(response)
        }
    }
}