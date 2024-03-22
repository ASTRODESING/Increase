package com.astrodesing.increase.di

import android.content.Context
import androidx.room.Room
import com.astrodesing.increase.data.databases.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModule {
    const val DATABASE_NAME = "Increase_BaseData"

    //PROVEEDOR DE LA BASE DE DATOS
    @Singleton
    @Provides
    fun provideBasedata(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(context, Database::class.java, DATABASE_NAME).build()
    }


    @Singleton
    @Provides
    fun provideBaseDaos(db:Database) = db.getDaoBase()

}