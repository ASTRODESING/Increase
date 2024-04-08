package com.astrodesing.increase.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.astrodesing.increase.data.entities.EntitiesModalidades

@Dao
interface DaoModalidades {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addModalidad(modalidad:EntitiesModalidades)
    @Query("Select * from modalidades")
    fun readModalidades(): List<EntitiesModalidades>
}