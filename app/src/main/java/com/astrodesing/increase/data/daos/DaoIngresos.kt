package com.astrodesing.increase.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.astrodesing.increase.data.entities.EntitiesCategorias
import com.astrodesing.increase.data.entities.EntitiesIngresos
import com.astrodesing.increase.data.entities.IngresosPorCategorias

@Dao
interface DaoIngresos {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addIngreso( ingreso: EntitiesIngresos)
    @Insert
    suspend fun addCategoria(categoria : EntitiesCategorias)

    @Transaction
    @Query("Select * from ingresos")
    suspend fun getIngresosPorCategorias():List<IngresosPorCategorias>
}