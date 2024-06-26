package com.astrodesing.increase.data.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.astrodesing.increase.data.daos.DaoBase
import com.astrodesing.increase.data.daos.DaoIngresos
import com.astrodesing.increase.data.daos.DaoModalidades
import com.astrodesing.increase.data.entities.EntitiesBase
import com.astrodesing.increase.data.entities.EntitiesCategorias
import com.astrodesing.increase.data.entities.EntitiesIngresos
import com.astrodesing.increase.data.entities.EntitiesModalidades


@Database(entities = [EntitiesBase::class,EntitiesIngresos::class,EntitiesCategorias::class,EntitiesModalidades::class], version = 2, exportSchema = false)
abstract class Database: RoomDatabase() {
    abstract fun getDaoBase():DaoBase
    abstract fun getDaoIngresos():DaoIngresos
    abstract fun getModalidades():DaoModalidades
}