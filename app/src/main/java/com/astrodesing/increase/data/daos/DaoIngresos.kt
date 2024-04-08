package com.astrodesing.increase.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.astrodesing.increase.data.entities.EntitiesBase
import com.astrodesing.increase.data.entities.EntitiesCategorias
import com.astrodesing.increase.data.entities.EntitiesIngresos
import com.astrodesing.increase.data.entities.IngresosPorCategorias
import dagger.Provides

@Dao
interface DaoIngresos {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addIngreso( ingreso: EntitiesIngresos)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCategoria(categoria : EntitiesCategorias)

    @Query("SELECT * FROM ingresos")
    fun readIngresosData(): List<EntitiesIngresos>

    @Query("SELECT * FROM categorias")
    fun readCategoryData(): List<EntitiesCategorias>

    @Transaction
    @Query("Select * from categorias")
    suspend fun getIngresosPorCategorias():List<IngresosPorCategorias>
}