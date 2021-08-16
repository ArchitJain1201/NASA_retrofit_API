package com.example.nasawalebhaiya.Room


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nasawalebhaiya.models.NASA


@Dao
interface NASADao {
    @Query("SELECT * FROM NASA")
    suspend fun getAllNASA(): List<NASA>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNASA(NASAList: List<NASA>)

    @Query("DELETE FROM NASA")
    suspend fun deleteAllNASA()
}