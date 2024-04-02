package com.astrodesing.increase.data.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.astrodesing.increase.data.daos.DaoBase
import com.astrodesing.increase.data.entities.EntitiesBase


@Database(entities = [EntitiesBase::class], version = 2, exportSchema = false)
abstract class Database: RoomDatabase() {
    abstract fun getDaoBase():DaoBase
}