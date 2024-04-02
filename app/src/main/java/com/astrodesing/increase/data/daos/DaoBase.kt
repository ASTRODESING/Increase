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
    fun readAllData(): List<EntitiesBase>

    @Query("SELECT * FROM base_data WHERE id=0")
    fun readFirstUserData():List<EntitiesBase>

}