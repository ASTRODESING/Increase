package com.astrodesing.increase.data.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.astrodesing.increase.data.entities.EntitiesBase

@Dao
interface DaoBase {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser( user:EntitiesBase)

    @Query("SELECT * FROM base_data")
    fun readAllData(): LiveData<List<EntitiesBase>>

    @Query("SELECT * FROM base_data WHERE id=1")
    fun readFirstUserData():LiveData<List<EntitiesBase>>

    @Query("Update base_data set first_init_aplication = :firstinit WHERE id=1 ")
    fun updateFirtsInit(firstinit:Boolean=true)
}